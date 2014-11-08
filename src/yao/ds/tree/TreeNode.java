package yao.ds.tree;

/**
 * Created by yao
 * Date: 2014/11/8 22:38
 *
 * 树的 Node 的递归定义
 */
public class TreeNode {
    public int value;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode root;

    public TreeNode(int newValue) {
        this.value = newValue;
        this.leftChild = null;
        this.rightChild = null;
    }

}
