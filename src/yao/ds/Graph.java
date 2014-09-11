package yao.ds;

/**
 * Created by yao on 2014/9/4.
 *
 * 无向图
 */
public class Graph {
    private final int V; // 顶点数
    private int E; //边数
    private Bag<Integer>[] adj; //邻接表

    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Bag<Integer> adj(int v) {
        return adj[v];
    }

    public int V() { return V;}
    public int E() { return E;}
}
