package leetcode;


/**
 * @Author Li Yang
 * @Created on 2021/11/9.
 * @Desc 合并两个有序链表
 * link https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode21 {

    public static void main(String[] args) {

    }

//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode sentinel = new ListNode(0);
//        ListNode result = sentinel;
//        merge(l1, l2, sentinel);
//        return result.next;
//    }
//
//    public static void merge(ListNode l1, ListNode l2, ListNode result) {
//        if (l1 == null) {
//            result.next = l2;
//            return;
//        }
//        if (l2 == null) {
//            result.next = l1;
//            return;
//        }
//        if (l1.val < l2.val) {
//            result.next = new ListNode(l1.val);
//            l1 = l1.next;
//        } else {
//            result.next = new ListNode(l2.val);
//            l2 = l2.next;
//        }
//        result = result.next;
//        merge(l1, l2, result);
//    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode temp = new ListNode();
        if (list1.val < list2.val) {
            temp = list1;
            temp.next = mergeTwoLists(list1.next, list2);
        } else {
            temp = list2;
            temp.next = mergeTwoLists(list1, list2.next);
        }
        return temp;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
