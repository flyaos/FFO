package yao.ds;

/**
 * Created by yao on 2014/9/4.
 *
 * 链表或者栈节点数据结构
 */
public class Node<T> {
    T item;
    Node next;

    public Node(T item) {
        this.item = item;
        this.next = null;
    }
}
