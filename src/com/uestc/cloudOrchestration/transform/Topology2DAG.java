package com.uestc.cloudOrchestration.transform;

import com.uestc.cloudOrchestration.model.*;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yao on 2014/8/27.
 * <p/>
 * 将拓扑 xml 解析为 DAG (有向无环图)
 */
public class Topology2DAG {

    public DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

    /**
     * 最终由拓扑转化成的有向无环图
     */
    public static DirectedAcyclicGraph DAG = new DirectedAcyclicGraph<AbstractElement, DefaultEdge>(DefaultEdge.class);

    /**
     * Capability id 到 NodeId 的映射 (n:1)
     * Requirement id 到 NodeId 的映射 (n:1)
     * Capability、Requirement 两者到NodeID的映射
     */
    public static HashMap<String, String> cap2NodeId = new HashMap<String, String>();
    public static HashMap<String, String> req2NodeId = new HashMap<String, String>();
    public static HashMap<String, String> capAndReq2NodeId = new HashMap<String, String>();

    /**
     * NodeId 到 NodeTemplate 对象的映射 (1:1)
     */
    public static HashMap<String, NodeTemplate> nodeId2Object = new HashMap<String, NodeTemplate>();

    // 被解析 xml 路径
    public String filePath;

    // 构造函数
    public Topology2DAG(String path) {
        this.filePath = path;
    }


    //transform XML file into DAG
    public DirectedAcyclicGraph<AbstractElement, DefaultEdge> parse() {

        parseNodeTemplates();
        parseRelationshipTemplates();

        return DAG;

    }

    /**
     * 将NodeTemplates加入DAG
     *
     */
    private void parseNodeTemplates() {

        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));

            /**
             * 解析NodeTemplate
             */
            NodeList nodeList = doc.getElementsByTagName("NodeTemplate");


            // 遍历每一个 NodeTemplate
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();

                NodeTemplate nodeTemplate = new NodeTemplate();
                ArrayList<Capability> cList = new ArrayList<Capability>();
                ArrayList<Requirement> rList = new ArrayList<Requirement>();
                String nodeId = "";

                // 取NodeTemplate的 id 和 name
                if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eNode = (Element) node;
                    nodeId = eNode.getAttribute("id");
                    nodeTemplate = new NodeTemplate(nodeId, eNode.getAttribute("name"));
                }

                // 取 NodeTemplate 的 Capabilities
                for (int j = 0; j < childNodes.getLength(); j++) {

                    if ("Capabilities".equals(childNodes.item(j).getNodeName())) {
                        // 可能有多个 Capability ，遍历
                        NodeList capabilityList = childNodes.item(j).getChildNodes();
                        for (int k = 0; k < capabilityList.getLength(); k++) {
                            Node caNode = capabilityList.item(k);
                            if (caNode != null && caNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eCaNode = (Element) caNode;
                                String capId = eCaNode.getAttribute("id");
                                cList.add(new Capability(capId, eCaNode.getAttribute("name")));
                                cap2NodeId.put(capId, nodeId);
                                capAndReq2NodeId.put(capId, nodeId);
                            }
                        }
                    }

                    if ("Requirements".equals(childNodes.item(j).getNodeName())) {
                        // 可能有多个 Requirement ，遍历
                        NodeList requirementList = childNodes.item(j).getChildNodes();
                        for (int k = 0; k < requirementList.getLength(); k++) {
                            Node caNode = requirementList.item(k);
                            if (caNode != null && caNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eCaNode = (Element) caNode;
                                String reqId = eCaNode.getAttribute("id");
                                rList.add(new Requirement(reqId, eCaNode.getAttribute("name")));
                                req2NodeId.put(reqId, nodeId);
                                capAndReq2NodeId.put(reqId, nodeId);
                            }
                        }
                    }
                }

                nodeTemplate.setCapabilities(cList);
                nodeTemplate.setRequirementses(rList);
                DAG.addVertex(nodeTemplate);

                nodeId2Object.put(nodeId, nodeTemplate);
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将RelationshipTemplates加入DAG
     *
     */
    private void parseRelationshipTemplates() {
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            /**
             * RelationshipTemplate
             */
            NodeList nodeList = doc.getElementsByTagName("RelationshipTemplate");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                RelationshipTemplate relationshipTemplate = new RelationshipTemplate();

                // RelationshipTemplate id 和 name
                if (node != null && node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eNode = (Element) node;
                    relationshipTemplate = new RelationshipTemplate(eNode.getAttribute("id"), eNode.getAttribute("name"));
                }

                // 取 RelationshipTemplate 的 source 和 target
                String source = null;
                String target = null;
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node eNode = childNodes.item(j);
                    if ("SourceElement".equals(childNodes.item(j).getNodeName())) {
                        Element e = (Element) eNode;
                        source = e.getAttribute("ref");
                        relationshipTemplate.setSourceElement(e.getAttribute("ref"));
                    } else if ("TargetElement".equals(childNodes.item(j).getNodeName())) {
                        Element e = (Element) eNode;
                        target = e.getAttribute("ref");
                        relationshipTemplate.setTargetElement(e.getAttribute("ref"));
                    }
                }

                DAG.addDagEdge(nodeId2Object.get(cap2NodeId.get(source)), nodeId2Object.get(cap2NodeId.get(target)));
                DAG.addVertex(relationshipTemplate); // 把 RelationshipTemplate 也加入 DAG
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DirectedAcyclicGraph.CycleFoundException e) {
            e.printStackTrace();
        }

    }

}
