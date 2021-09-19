package com.liang.demo;

import java.util.Arrays;

/**
 * @author : liyang
 * @date : 2021/9/18
 * String类的基本操作
 */
public class StringDemo {

    public static void main(String[] args) {
        //the firsr line code!
        String word = "Hello World";
        System.out.println(word);
        //字符串可直接用+号拼接
        word = word +" Hello Java";
        //length方法,返回字符串的长度
        System.out.println(word.length());
        System.out.println(word);
        //字符串用spilt方法可以按照输入的符号拆分成数组
        //idea crtl+shift+t可以根据方法直接生成返回值
        String[] s = word.split(" ");
        //由于数组类没有单独的字符串打印方法,推荐使用Arrays.toString方法
        System.out.println(Arrays.toString(s));
        //replace为string的字符串替换方法,根据输入的老的字符和要替换的新的字符完成操作
        //这里要注意,进行replace操作以后,需要对word进行重新赋值
        word = word.replace("Hello","Hi");
        System.out.println(word);
        //charAt方法,返回下标对应的字符
        System.out.println(word.charAt(0));
        //String的toCharArray方法可以将string类按位拆分为char类型的数组
        char[] chars = word.toCharArray();
        System.out.println(Arrays.toString(chars));
        // indexOf 获取当前字符串中的指定字符的第一次出现的位置,lastIndexOf 获取当前字符串中的指定字符的最后一次出现的位置,算法中常用
        System.out.println(word.indexOf("H")+","+word.lastIndexOf("H"));
        //toLowerCase 将字符串全部转为小写
        System.out.println(word.toLowerCase());
        //toUpperCase 将字符串全部转为大写
        System.out.println(word.toUpperCase());
    }
}
