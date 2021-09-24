package com.liang.demo;

import java.util.Arrays;

/**
 * @author : liyang
 * @date : 2021/9/18
 * String类的常用方法
 */
public class StringDemo {

    public static void main(String[] args) {
        //the firsr line code!
        //String类创建的几种方式
        //直接声明并赋值
        String word = "Hello World";
        //先创建一个string类
        String newWord = new String();
        //再赋值
        newWord = "newWord";
        //String 对象创建并赋值
        String newestWord = new String("newestWord");
        System.out.println(word);
        System.out.println(newWord);
        System.out.println(newestWord);
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
        //substring方法,按下表截取,substring(6)为截取第6位之后的所有字符,含第六位
        System.out.println(word.substring(6));
        //substring(6,10)为截取第6位,到第10位的所有字符含第六位,不含第10位
        System.out.println(word.substring(6,10));
        //word.startsWith("H") 判断字符串是否为该字符开头
        System.out.println(word.startsWith("H"));
        //word.startsWith("H",2)判断字符串的指定位置是否为是否为该字符开头
        System.out.println(word.startsWith("W",3));
        String str1 = "hi world hi java";
        //equals判断文本内容是否一致
        System.out.println(str1.equals(word));
        //equalsIgnoreCase 不区分大小写判断文本是否一致
        System.out.println(str1.equalsIgnoreCase(str1));
        String str2 = " hi world hi java ";
        //trim 去掉字符串两端空格
        System.out.println(str2.trim());
        //concat 在原有的字符串的基础上加上指定字符串
        System.out.println(str2.concat("i love code!"));
        //常用的String类方法,大概就是这些了吧,以后就不再更新了
    }
}
