package com.liang.demo;

/**
 * @Author Li Yang
 * @Created on 2021/10/14.
 * @Desc FizzBuzz问题
 * 写一个程序打印1到100这些数字。但是遇到数字为3的倍数的时候，打印“Fizz”替代数字，5的倍数用“Buzz”代替，既是3的倍数又是5的倍数打印 FizzBuzz
 */
public class FizzBuzzDemo {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(JudgeNum(i));
        }
    }

    public static String JudgeNum(int i) {
        String result = "";
        if (i % 3 == 0 && i % 5 == 0) {
            result = "FizzBuzz";
        } else if (i % 3 == 0) {
            result = "Fizz";
        } else if (i % 5 == 0) {
            result = "Buzz";
        } else {
            result += i;
        }
        return result;
    }


}
