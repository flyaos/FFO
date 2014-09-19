package yao.ds;

/**
 * Created by yao on 2014/9/4.
 * <p/>
 * 链表或者栈节点数据结构
 */
public class Node<T> {
    T item;
    Node next;

    public Node() {
        this(null, null);
    }

    public Node(T item) {
        this(item, null);
    }

    public Node(T item, Node next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
