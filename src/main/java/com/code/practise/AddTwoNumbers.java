package com.code.practise;

import com.code.tools.ListNode;

/**
 * description
 *
 * @author Summer 2020/03/27 14:38
 */
public class AddTwoNumbers {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1,l2
     * @author Summer 2020-03-26 15:05
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode newHead = new ListNode(0);

        ListNode p = newHead;

        int flag = 0;

        while(l1 != null || l2 != null){

            l1 = l1 == null ? new ListNode(0) : l1;
            l2 = l2 == null ? new ListNode(0) : l2;

            int sum = l1.val + l2.val + flag;

            flag = sum >= 10 ? 1 : 0;

            p.val = sum % 10;

            if(l1.next != null || l2.next != null){
                p.next = new ListNode(0);
                p = p.next;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        if(flag == 1){

            p.next = new ListNode(1);

        }

        return newHead;

    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 正序！！！ 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param l1,l2
     * @author Summer 2020-03-26 15:05
     * @return
     */
    //todo
    public ListNode addTwoNumbersOrder(ListNode l1, ListNode l2) {


        ListNode newHead = new ListNode(0);

        ListNode p = newHead;

        int flag = 0;

        while(l1 != null || l2 != null){

            l1 = l1 == null ? new ListNode(0) : l1;
            l2 = l2 == null ? new ListNode(0) : l2;

            int sum = l1.val + l2.val + flag;

            flag = sum >= 10 ? 1 : 0;

            p.val = sum % 10;

            if(l1.next != null || l2.next != null){
                p.next = new ListNode(0);
                p = p.next;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        if(flag == 1){

            p.next = new ListNode(1);

        }

        return newHead;

    }


}
