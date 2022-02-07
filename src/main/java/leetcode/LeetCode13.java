package leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Li Yang
 * @Created on 15/12/2021.
 * @Desc 罗马数字转整数
 * link: https://leetcode-cn.com/problems/roman-to-integer/
 */
public class LeetCode13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MDCXCV"));
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> romaNum = new HashMap<>();
        romaNum.put("I", 1);
        romaNum.put("V", 5);
        romaNum.put("X", 10);
        romaNum.put("L", 50);
        romaNum.put("C", 100);
        romaNum.put("D", 500);
        romaNum.put("M", 1000);
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
           int num = romaNum.get(String.valueOf(s.charAt(i)));
            int nextNum = 0;
            if (i != s.length() - 1) {
                nextNum = romaNum.get(String.valueOf(s.charAt(i + 1)));
            }
            if (num > nextNum) {
                result += num;
            } else if (num < nextNum) {
                result = result + (nextNum - num);
                i++;
            } else {
                result += num;
            }
        }
        return result;
    }
}
