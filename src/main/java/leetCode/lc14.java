package leetCode;

import java.util.Arrays;

/**
 * @Author Li Yang
 * @Created on 2021/8/24.
 * @Desc 14. 最长公共前缀  https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class lc14 {
    public static void main(String[] args) {
        String[] strs = {"c", "cbc", "c", "ca"};
        longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int k = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].length() > strs[i + 1].length()) {
                k = i + 1;
            }
        }
        String firStr = strs[k];
        String prefix = "";
        for (int i = 0; i < firStr.length(); i++) {
            for (String str : strs) {
                if (str == "") {
                    return "";
                }
                if (firStr.charAt(i) != str.charAt(i)) {
                    return prefix;

                }
            }
            prefix = prefix + firStr.charAt(i);
        }
        return prefix;
    }
}