package yao.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yao on 2014/8/13.
 */
public class BinarySearchTree {

    public TreeNode root;

    /**
     * 根结点指针，空树为null
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * 初始化根节点
     *
     * @param k_value
     * @return
     */
    public boolean init(int k_value) {
        root.value = k_value;
        root.leftChild = null;
        root.rightChild = null;
        return true;
    }

    /**
     * 迭代插入
     * 插入一个结点，二叉排序树的插法
     *
     * @param v_key
     * @return
     */
    public boolean insert(int v_key) {
        if (root == null) {
            root = new TreeNode(v_key);
        } else {
            TreeNode currNode = root;
            TreeNode parentNode;
            while (true) {
                parentNode = currNode;
                if (v_key < currNode.value) {
                    currNode = currNode.leftChild;
                    if (currNode == null) {
                        parentNode.leftChild = new TreeNode(v_key);
                        break;
                    }
                } else {
                    currNode = currNode.rightChild;
                    if (currNode == null) {
                        parentNode.rightChild = new TreeNode(v_key);
                    }
                }
            }
        }

        return true;

    }

    public void insertKey(int key) {
        if (root == null) {
            root = new TreeNode(key);
        } else {
            TreeNode tmp = root;
            while (tmp != null) {
                if (key > tmp.value) {
                    if (tmp.rightChild == null) {
                        tmp.rightChild = new TreeNode(key);
                        break;
                    } else {
                        tmp = tmp.rightChild;
                    }
                } else {
                    if (tmp.leftChild == null) {
                        tmp.leftChild = new TreeNode(key);
                        break;
                    } else {
                        tmp = tmp.rightChild;
                    }
                }
            }
        }

    }

    /**
     * 递归插入
     *
     * @param p     根节点
     * @param v_key 插入的数
     * @return
     */
    public TreeNode insert(TreeNode p, int v_key) {
        if (p == null) {
            return new TreeNode(v_key);
        }
        if (v_key < p.value) {
            p.leftChild = insert(p.leftChild, v_key);
        } else if (v_key > p.value) {
            p.rightChild = insert(p.rightChild, v_key);
        } else {
            ;
        }
        return p;

    }

    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();
//        binaryTree.init(17);
//        binaryTree.insert(15);
        ArrayList<Integer> a = new ArrayList(Arrays.asList(7, 8, 1, 2, 3, 4, 5));
        for (int data : a) {
            binaryTree.insertKey(data);
        }
        System.out.println();

    }


}
