package leetcode;

/**
 * @author : liyang
 * @date : 2021/9/2
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */

public class LeetCodeSword22 {
    public static void main(String[] args) {
        //声明链表
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thitdNode = new ListNode(3);
        ListNode fourthNode = new ListNode(4);
        //将链表用next方法链接
        firstNode.next = secondNode;
        secondNode.next = thitdNode;
        thitdNode.next = fourthNode;
        //输出链表的值
        System.out.println(getKthFromEnd(firstNode, 3).val);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        //采用快慢双指针解法,声明一个快指针,一个慢指针
        ListNode fast = head;
        ListNode slow = head;
        //快指针先行k步
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        //当k<=0时,快慢指针一起进行,当快指针走到链表劲头,慢指针的位置就是倒数k所在的位置
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //返回慢指针所在的位置
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
