package com.code.practise;

import com.code.tools.ListNode;

/**
 * description
 *
 * @author Summer 2020/03/27 14:37
 */
public class SwapListNodePairs {

    public ListNode swapListNodePairs(ListNode head) {

        //长度小于2，直接返回
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = new ListNode(0);

        newHead.next = head;

        ListNode p = newHead;

        while(p.next !=null && p.next.next != null){

            //循环交换的第一个节点
            ListNode node1 = p.next;
            //循环交换的第二个节点
            ListNode node2 = node1.next;
            //下一次交换的第一个节点
            ListNode next = node2.next;

            //交换
            node2.next = node1;
            node1.next = next;
            p.next = node2;

            p = node1;

        }

        return newHead.next;
    }

}
