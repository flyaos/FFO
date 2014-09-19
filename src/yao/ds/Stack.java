package yao.ds;

/**
 * Created by yao on 2014/9/9.
 * <p/>
 * 栈的简单实现
 */
public class Stack<T> {
    public Node top;

    public Stack() {
        top = new Node();
    }

    public Node peek() {
        if (top != null) {
            return top;
        }
        return null;
    }

    public Node pop() {
        if (top != null) {
            Node tmp = new Node(top.item);
            top = top.next;
            return tmp;
        }
        return null;
    }

    public void push(Node n) {
        if (n != null) {
            n.next = top;
            top = n;
        }
    }
}
