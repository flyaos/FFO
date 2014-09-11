package yao.ds;

import java.util.Scanner;

/**
 * Created by yao on 2014/8/8.
 *
 * 单链表
 */
public class LinkList {

    public int value;
    public LinkList next;

    public LinkList() {
        this.value = -1;
        this.next = null;
    }

    public LinkList(int value) {
        this.value = value;
        this.next = null;
    }

    public void add(LinkList head, LinkList linkList) {
        LinkList p = head;
        if (head == null) return;
        while (p.next != null) {
            p = p.next;
        }
        p.next = linkList;
    }

    //打印单链表
    public static void print(LinkList head, boolean withHead) {
        if (head == null) {
            System.out.println("LinkList List is empty");
        }
        LinkList p = head;
        if (withHead) {
            p = head.next;
        }
        while (p != null) {
            System.out.println(p.value + " ");
            p = p.next;
        }
    }

    // 带头节点的单链表逆置
    public static LinkList reviseWithHead(LinkList head) {

        LinkList p = head.next;
        LinkList p_move = p.next; //移动的指针，总指向最后一个，从第二个开始排

        while (p_move != null) {
            LinkList p_first = head.next; //备份第一个

            p.next = p_move.next; //第一步：p 指向 p_move 后的那个节点
            p_move.next = p_first; //第二步：将待排数指向第一个节点
            head.next = p_move;   //第三部：头节点指向 p_move

            p_move = p.next; //移动指针修正
        }

        return head;
    }

    // 不带头结点的单链表逆置
    public static LinkList reviseWithoutHead(LinkList linkList) {

        LinkList p = linkList;
        LinkList p_move = linkList.next;
        LinkList p_first = linkList;
        while (p_move != null) {
            p.next = p_move.next;
            p_move.next = p_first;
            p_first = p_move;

            p_move = p.next;

        }
        return p_first;

    }

    // 给定一个结点，删除当前结点，时间复杂度 O(1)
    //
    public static void deleteNode(LinkList p) {
        p.value = p.next.value;
        p.next = p.next.next;
        p.next.next = null;
    }


    public static void main(String args[]) {
        System.out.println("input the array:");
        Scanner sc = new Scanner(System.in);
        String[] inputArray = sc.next().split(",");

        // 带头结点
        LinkList head1 = new LinkList();
        for (String in : inputArray) {
            head1.add(head1, new LinkList(Integer.parseInt(in)));
        }

        //申请一个不带头结点的
        LinkList head2 = new LinkList(Integer.parseInt(inputArray[0]));
        for (int i = 1; i < inputArray.length; i++) {
            head2.add(head2, new LinkList(Integer.parseInt(inputArray[i])));

        }

        LinkList head_1 = reviseWithHead(head1);
        print(head_1,true);

        LinkList head_2 = reviseWithoutHead(head2);
        print(head_2,false);

    }

}
