package com.uestc.cloudOrchestration.transform;

import com.uestc.cloudOrchestration.model.AbstractElement;
import org.jgrapht.experimental.dag.DirectedAcyclicGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.Iterator;

/**
 * Created by yao on 2014/8/28.
 *
 * 生成 PlanSkeleton
 */
public class POG2PlanSkeleton {

    public static void planSkeleton(DirectedAcyclicGraph<AbstractElement, DefaultEdge> POG) {
        Iterator<AbstractElement> iterator = POG.iterator();
        while (iterator.hasNext()) {
            AbstractElement element = iterator.next();

            // 打印节点入度
            System.out.println(POG.inDegreeOf(element));
        }
    }
}
