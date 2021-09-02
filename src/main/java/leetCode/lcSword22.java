package leetCode;

/**
 * @author : liyang
 * @date : 2021/9/2
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */

public class lcSword22 {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thitdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);
        firstNode.next = secondNode;
        secondNode.next = thitdNode;
        thitdNode.next = fourthNode;
        System.out.println(getKthFromEnd(firstNode, 3).val);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
