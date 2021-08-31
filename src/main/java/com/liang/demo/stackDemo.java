package com.liang.demo;

import java.util.Stack;

/**
 * @Author Li Yang
 * @Created on 2021/8/31.
 * @Desc 栈类型方法的demo
 */
public class stackDemo {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //判断栈中是否为空,没有则返回true,有则返回false
        System.out.println(stack.empty());
        //add方法添加元素,添加成功返回true
        stack.add("s");
        stack.add("t");
        //push方法向栈顶添加元素,返回结果是当前添加的元素
        stack.push("r");
        System.out.println(stack.push("i"));
        System.out.println(stack.add("n"));
        System.out.println(stack);
        // pop方法移除并返回栈顶元素，如果是空栈，会抛出异常：EmptyStackException
        System.out.println(stack.pop());
        //peek方法,查看此堆栈顶部的对象，而不从堆栈中删除它
        System.out.println(stack.peek());
        //search方法,返回一个对象在此堆栈上的基于1的位置,栈是先进后出,先入栈的元素在下,后入栈的元素再上
        System.out.println(stack.search("s"));
        System.out.println(stack);
        System.out.println(stack.empty());
    }
}
