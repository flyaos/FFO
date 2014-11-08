package yao.ds.Graph;

import java.util.Queue;

/**
 * Created by yao on 2014/9/4.
 *
 * 广度优先遍历
 * 无向图单点连通性
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.E()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = null;
        marked[s] = true; // 起点
        queue.add(s); // 加入队列

        while (!queue.isEmpty()) {
            int v = queue.peek(); // 队列中删除一个顶点
            for (int w : G.adj(s)) {
                if (!marked[w]) {
                    edgeTo[w] = v; // 保存最短路径的最后一条边
                    marked[w] = true; // 标记已经访问
                    queue.add(w); // 将访问过的加入队列中
                }
            }
        }
    }

    // 如果 markd[v] 为 false 说明遍历的时候还没访问到，路径不存在
    public boolean hasPathTo(int v) {
        return marked[v];
    }
}
