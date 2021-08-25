package leetCode;

import java.util.Arrays;

/**
 * @Author Li Yang
 * @Created on 2021/8/24.
 * @Desc 14. 最长公共前缀  https://leetcode-cn.com/problems/longest-common-prefix/
 */

public class lc14 {
    public static void main(String[] args) {
        String[] strs = {"abab", "aba", ""};
        longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        //先判断数组是否为空,为空则直接返回
        if (strs == null || strs.length == 0) {
            return "";
        }
        //将数组第一位设置为前缀
        String res = strs[0];
        for (String str : strs) {
            //用indexOf的返回结果判断前缀是否一致
            while (str.indexOf(res) != 0) {
                //如果不一致,则说明该索引不是公共索引,将索引长度调整-1
                //如果res是最小长度的值,也不包含索引,则说明该数组没有公共前缀,不是最小长度则慢慢缩减res的值进行比较
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

}