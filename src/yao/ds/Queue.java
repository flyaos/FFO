package yao.ds;

/**
 * Created by yao on 2014/9/9.
 * <p/>
 * 队列的简单实现
 */
public class Queue {
    Node first, last;

    public void enqueue(Node n) {
        if (n != null) {
            n.next = last;
            last = n;
        }
    }

    public Node dequeue() {
        if (first == null) {
            return null;
        } else {
            Node tmp = new Node(first.item);
            first = first.next;
            return tmp;
        }
    }
}
