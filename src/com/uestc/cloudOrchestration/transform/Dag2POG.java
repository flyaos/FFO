package com.uestc.cloudOrchestration.transform;

import com.uestc.cloudOrchestration.model.AbstractElement;
import com.uestc.cloudOrchestration.model.NodeTemplate;
import com.uestc.cloudOrchestration.model.RelationshipTemplate;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.Iterator;

import static com.uestc.cloudOrchestration.transform.Topology2DAG.capAndReq2NodeId;

/**
 * Created by yao on 2014/8/27.
 *
 * 由 DAG 生成 POG
 */
public class Dag2POG {

    private DirectedAcyclicGraph<AbstractElement, DefaultEdge> dag;
    static DirectedAcyclicGraph<AbstractElement, DefaultEdge> POG = new DirectedAcyclicGraph<AbstractElement, DefaultEdge>(DefaultEdge.class);

    public Dag2POG(DirectedAcyclicGraph<AbstractElement, DefaultEdge> dag) {
        this.dag = dag;
    }

    public DirectedAcyclicGraph<AbstractElement, DefaultEdge> generatePOG() throws DirectedAcyclicGraph.CycleFoundException {
        DirectedAcyclicGraph<AbstractElement, DefaultEdge> DAG = this.dag;
        Iterator<AbstractElement> iterator = DAG.iterator();

        /**
         * 将node和Relationship都加入POG的顶点集
         */
        while (iterator.hasNext()) {
            AbstractElement element = iterator.next();
            POG.addVertex(element);

            if (element instanceof RelationshipTemplate) {
                RelationshipTemplate rt = (RelationshipTemplate) element;
                NodeTemplate source_nt = Topology2DAG.nodeId2Object.get(capAndReq2NodeId.get(rt.getSourceElement()));
                NodeTemplate target_nt = Topology2DAG.nodeId2Object.get(capAndReq2NodeId.get(rt.getTargetElement()));
                if (element.getName().contains("hosted")) {
                    POG.addDagEdge(target_nt, rt);
                    POG.addDagEdge(rt, source_nt);
                } else if (element.getName().contains("connects")) {
                    POG.addDagEdge(target_nt, rt);
                    POG.addDagEdge(source_nt, rt);
                }
            }
        }

        return POG;
    }

}
