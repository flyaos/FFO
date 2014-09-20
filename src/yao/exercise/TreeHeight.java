package yao.exercise;

/**
 * Created by yao on 2014/9/20.
 * <p/>
 * 来自待字闺中的题目
 *
 * 描述：有一棵树，不一定是二叉树，有n个节点，编号为0到n-1.
 * 有一个数组A，数组的索引为0到n-1，数组A[i]表示i节点的父节点的索引
 * 求树的最大高度
 *
 * 方法：遍历求出最大高度，记录已经访问过的索引节点，避免重复计算
 */
public class TreeHeight {

    static boolean[] visited;
    static int[] treeNode;

    public static void main(String[] args) {
        treeNode = new int[]{1, 2, 5, 2, -1, 3, 4};
        getTreeHeight(treeNode);
    }

    private static void getTreeHeight(int[] treeNode) {

        visited = new boolean[treeNode.length];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int maxHeight = -1;

        // 从0开始遍历，求出高度，
        for (int i = 0; i < treeNode.length; i++) {
            if (!visited[i]) {
                maxHeight = Math.max(maxHeight, getHeight(i));
            }
        }
    }

    private static int getHeight(int i) {
        int length = 0;

        if(!visited[i])
            visited[i] = true; // 已访问

        int parent = treeNode[i];
        while (parent != -1) {
            visited[parent] = true;
            parent = treeNode[parent];
            length++;
        }
        return length;
    }
}
