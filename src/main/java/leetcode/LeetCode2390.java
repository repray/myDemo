package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Li Yang
 * @date: 2024-09-14
 * @description: 2390. 从字符串中移除星号 https://leetcode.cn/problems/removing-stars-from-a-string/description/
 */
public class LeetCode2390 {
    public static void main(String[] args) {
        String s = removeStars("leet**cod*e");
        System.out.println(s);
    }

    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!"*".equals(String.valueOf(s.charAt(i)))) {
                sb.append(s.charAt(i));
            } else {
                sb.setLength(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
