package com.code.practise;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Summer 2021/06/17 15:07
 */
public class MergeTwoLists {

    public static void main(String[] args) {

        new MergeTwoLists().demo();

    }

    public void demo(){
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(4);

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);

        ListNode p = mergeTwoLists(h1,h2);

        while (p.next != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode h = new ListNode(0);

        ListNode p = h;

        while(l1 != null || l2!= null){

            int v;

            if(l1 == null){
                p.next = l2;
                break;
            }
            if(l2 == null){
                p.next = l1;
                break;
            }

            if(l1.val < l2.val){
                v = l1.val;
                l1 = l1.next;
            }else{
                v = l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(v);
            p = p.next;
        }

        return h.next;

    }

}
