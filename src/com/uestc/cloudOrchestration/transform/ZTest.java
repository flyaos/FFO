package com.uestc.cloudOrchestration.transform;

import com.uestc.cloudOrchestration.model.AbstractElement;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

/**
 * Created by yao on 2014/8/28.
 */
public class ZTest {
    /**
     * test
     *
     * @param args
     */
    public static void main(String args[]) throws DirectedAcyclicGraph.CycleFoundException {
        String path = "c:\\aa.xml";
        Topology2DAG pt = new Topology2DAG(path);
        DirectedAcyclicGraph<AbstractElement, DefaultEdge> DAG = pt.parse();
        Dag2POG p = new Dag2POG(DAG);
        POG2PlanSkeleton.planSkeleton(p.generatePOG());


    }
}
