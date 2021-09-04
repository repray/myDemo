package com.liang.demo;


/**
 * @author : liyang
 * @date : 2021/9/4
 */
public class listNodeDemo {
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
        //next为指向下一个链表节点，val为获取节点的值
        System.out.println(firstNode.next.val);
    }

    //链表节点的结构为,本节点的值和指向的下一个节点,多个节点通过next方法相连接,构成了链表
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
