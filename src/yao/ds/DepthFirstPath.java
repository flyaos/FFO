package yao.ds;

import java.util.ArrayList;

/**
 * Created by yao on 2014/9/4.
 * <p/>
 * 深度优先遍历路径
 * 单点连通性
 */
public class DepthFirstPath {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPath(Graph G, int s) {
        marked = new boolean[G.V()];
        this.s = s;
        this.edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v; // 保存每次的路径
                dfs(G, w);
            }
        }
    }

    // 是否存在路径
    public boolean hasPathsTo(int v) {
        return marked[v];
    }

    // 将路径通过 edge[] 遍历出来
    public ArrayList<Integer> pathTo(int v) {
        ArrayList<Integer> paths = new ArrayList<Integer>();
        if (!hasPathsTo(v)) return null;
        for (int x = v; x != s; x = edgeTo[x]) {
            paths.add(x);
        }
        paths.add(s);
        return paths;
    }
}
