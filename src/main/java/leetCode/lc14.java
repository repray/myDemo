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
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (String str : strs) {
            //表示必须从0开始包含
            while (str.indexOf(res) != 0) {
                //开始滑动
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

}