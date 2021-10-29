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
