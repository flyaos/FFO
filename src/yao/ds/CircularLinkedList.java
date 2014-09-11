package yao.ds;

/**
 * Created by yao on 2014/9/12.
 */
public class CircularLinkedList<T> implements IListable<T> {

    public Node<T> head, tail;

    /**
     * 建空表，头为结点和尾结点都指向自己
     */
    public CircularLinkedList() {
        this(null);
    }

    /**
     * 建表，如果参数为空，建空表；若参数不为空，建一张有头有尾的结点，尾结点的指针指向头结点
     */
    public CircularLinkedList(T data) {
        if (data == null) {
            head = new Node<T>(data, null); //创建头结点，数据为data,指针为空
            tail = head; //尾结点和头结点相同
            tail.setNext(head); //尾结点指针域指向头结点，使首尾形成环
        } else {
            head = new Node<T>();
            tail = new Node<T>(data, head);
            head.setNext(tail);//等价于head.next = tail;
        }
    }

    /**
     * 清空链表，头=尾，this = null;
     */
    public void clear() {
        removeAll();
        head.setNext(tail);
        tail.setNext(head);
        head = tail;
    }

    /**
     * 如果头=尾，返回true;否则，返回false
     */
    public boolean isEmpty() {
        return tail == head;
    }

    /**
     * 获取链表当前元素个数，即表长
     */
    public int length() {
        int len = 0;
        Node<T> temp = head;
        while (temp.getNext() != head) {
            len++;
            temp = temp.getNext();
        }
        return len;
    }

    /**
     * 取index处的数据元素
     */
    public T getElement(int index) {
        if (index < 0) return null;
        Node<T> temp = head;
        int j = 0;
        while (j <= index && temp.getNext() != head) {
            j++;
            temp = temp.getNext();
        }
        return temp.getItem();
    }

    /**
     * 将参数链表添加到当前链表的后面
     */
    public boolean add(IListable<T> list) {
        CircularLinkedList<T> sList = (CircularLinkedList<T>) list;
        tail.setNext(sList.head.getNext());
        sList.tail.setNext(head);
        sList.head.setNext(null);
        sList.head = null;
        return true;
    }

    /**
     * 尾添
     */
    public boolean add(T element) {
        if (element == null) return false;
        Node<T> temp = new Node<T>(element, head);
        tail.setNext(temp);
        tail = temp;
        return true;
    }

    /**
     * 添加头部
     */
    public boolean addHead(T element) {
        if (element == null) return false;
        Node<T> temp = new Node<T>(element, head.getNext());
        head.setNext(temp);
        return true;
    }

    /**
     * 任意位置添加
     */
    public boolean addByIndex(int index, T element) {
        if (element == null) return false;
        if (index <= 0)
            addHead(element);
        if (index >= length())
            add(element);
        if (index > 0 && index < length()) {
            int j = 0;
            Node<T> temp = head;
            Node<T> tempNext = temp.getNext();
            while (j < index && tempNext != head) {
                j++;
                temp = tempNext;
                tempNext = tempNext.getNext();
            }
            Node<T> node = new Node<T>(element, tempNext);
            temp.setNext(node);
        }
        return true;
    }

    /**
     * 删除循环表中所有的数据元素
     */
    public boolean removeAll() {
        if (isEmpty()) return false;
        Node<T> tempNext = head.getNext();
        while (tempNext != head) {
            tempNext = tempNext.getNext();
            head.setNext(tempNext);
        }
        return true;
    }

    /**
     * 删除指定位置上的元素
     */
    public T remove(int index) {
        if (isEmpty()) return null;
        T element = null;
        if (index <= 0)
            return removeHead();
        if (index > length())
            index = length() - 1;
        if (index > 0) {
            int j = 0;
            Node<T> temp = head;
            Node<T> tempNext = head.getNext();
            while (j < index && tempNext != head) {
                temp = tempNext;
                tempNext = tempNext.getNext();
                j++;
            }
            element = tempNext.getItem();
            temp.setNext(tempNext.getNext());
        }
        return element;
    }

    /**
     * 删除表中的第一条element的数据
     */
    public T remove(T element) {
        if (isEmpty()) return null;
        if (element == null) return null;
        Node<T> temp = head.getNext();
        while (temp != head) {
            if (!(element.equals(temp.getItem()))) {
                temp = temp.getNext();
            } else {
                return element;
            }
        }
        return null;
    }

    /**
     * 删除表头数据
     */
    private T removeHead() {
        if (isEmpty()) return null;
        Node<T> firstNode = head.getNext();
        T element = firstNode.getItem();
        head.setNext(head.getNext().getNext());
        return element;
    }

    /**
     * 修改指定位置上的数据元素，并将原数据返回给T
     */
    public T setElement(int index, T element) {
        if (isEmpty()) return null;
        if (element == null) return null;
        T tempEle = null;
        if (index < 0) {
            return null;
        }
        if (index >= length() - 1) {
            index = length() - 1;
            tempEle = tail.getItem();
            tail.setItem(element);
            return tempEle;
        } else if (index > 0 && index < length() - 1) {
            Node<T> temp = head;
            int j = 0;
            while (j < index && temp.getNext() != head) {
                j++;
                temp = temp.getNext();
            }
            tempEle = temp.getItem();
            temp.setItem(element);
        }
        return tempEle;
    }

    /**
     * 重写父类toString()方法
     */
    public String toString() {
        if (isEmpty())
            return "[ ]";
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        int L = length();
        for (int i = 0; i < L; i++) {
            sb.append(getElement(i) + " ");
        }
        sb.append("]");
        return sb.toString();
    }

}
