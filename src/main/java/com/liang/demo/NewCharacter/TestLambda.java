package com.liang.demo.NewCharacter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Li Yang
 * @date 2021/10/29
 * Lambda 表达式
 */
public class TestLambda {

    /**
     * Lambda表达式允许把函数作为一个方法的参数
     * 几种常见的Lambda表达式：
     * // 1. 不需要参数,返回值为 5
     * () -> 5
     *
     * // 2. 接收一个参数(数字类型),返回其2倍的值
     * x -> 2 * x
     *
     * // 3. 接受2个参数(数字),并返回他们的差值
     * (x, y) -> x – y
     *
     * // 4. 接收2个int型整数,返回他们的和
     * (int x, int y) -> x + y
     *
     * // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
     * (String s) -> System.out.print(s)
     */
    public static void main(String[] args) {
        oldCode();
        System.out.println("------");
        newCode();
    }

    //老的写法
    public static void oldCode() {
        List<String> list = Arrays.asList("Hello", "World", "I", "am", "Java");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(list);
    }


    //lambda写法
    public static void newCode() {
        List<String> list = Arrays.asList("Hello", "World", "I", "am", "Java");
        list.sort((String s1, String s2) -> {
            return s1.length() - s2.length();
        });
        System.out.println(list); // 结果：[I, am, Java, Hello, World]
    }
}
