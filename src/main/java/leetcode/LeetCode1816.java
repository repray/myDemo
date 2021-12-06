package leetcode;

import java.util.ArrayList;

/**
 * @author Li Yang
 * @date 2021/12/6
 * link: https://leetcode-cn.com/problems/truncate-sentence/
 * 1816. 截断句子
 */
public class LeetCode1816 {

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }

    public static String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        ArrayList strList = new ArrayList(k);
        for (int i = 0; i < k; i++) {
            strList.add(s1[i]);
        }
        String replace = strList.toString().replace(",", "");
        replace = replace.substring(1, replace.length() - 1);
        return replace;
    }

    /**
     * 更好的解法,效率更高
     */
    public static String betterMethodTruncateSentence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
                if (count == k) {
                    return s.substring(0, i);
                }
            }
        }
        return s;
    }
}
