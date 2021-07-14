package com.code.practise;

import com.code.tools.ListNode;

/**
 * 给定一个单向链表，交换每2个相邻的元素。
 * 比如：1->2->3->4->5，返回2->1->4->3->5。
 * 要求：常数级空间复杂度，需要交换节点，不能直接交换值。
 *
 * @author Summer 2021/06/18 14:18
 */
public class SwapNeiber {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);

        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        ListNode h = new SwapNeiber().reverseList(h1);

        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }

    }

    public ListNode solution(ListNode h){

        if( h == null || h.next == null){
            return h;
        }

        ListNode nh = new ListNode(0);

        nh.next = h;

        ListNode p = nh;

        while(p.next != null && p.next.next != null){

            ListNode n1 = p.next;
            ListNode n2 = n1.next;

            ListNode next = n2.next;

            n1.next = next;
            n2.next = n1;

            p.next = n2;

            p = n1;

        }

        return nh.next;

    }

    /**
     * 链表倒置
     *
     * @param head
     * @author Summer 2021-06-18 15:16
     * @return com.code.tools.ListNode
     */
    public ListNode reverseList(ListNode head) {



        ListNode n = null;

        while (head != null){

            ListNode p = head;

            head = head.next;

            p.next = n;

            n = p;

        }

        return n;
    }

}
