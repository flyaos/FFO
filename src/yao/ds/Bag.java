package yao.ds;

import java.util.Iterator;

/**
 * Created by yao on 2014/9/4.
 *
 * 简单链表结构
 */
public class Bag<T> implements Iterable<T> {

    private Node first;

    public void add(T item) {
        Node oldfirst = first;
        first = new Node(item);
        first.next = oldfirst;

    }

    @Override
    public Iterator<T> iterator() {
        return new LisIterator() {
        };
    }

    private class LisIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = (T) current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

}
