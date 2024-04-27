package com.liang.demo;

/**
 * 查看当前cpu运行核心数
 */
public class CheckCoreNum {

    public static void main(String[] args) {
        System.out.println("当前cpu运行核心数:"+Runtime.getRuntime().availableProcessors());
    }
}
