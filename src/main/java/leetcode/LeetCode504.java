package leetcode;

/**
 * @Author Li Yang
 * @Created on 7/3/2022.
 * @Desc 504. 七进制数
 * link: https://leetcode-cn.com/problems/base-7/
 */
public class LeetCode504 {

    public static void main(String[] args) {
        int num = 100;
        System.out.println(convertToBase7(num));
    }

    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }
}
