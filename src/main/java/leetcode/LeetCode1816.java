package leetcode;

import java.util.ArrayList;

/**
 * @author Li Yang
 * @date 2021/12/6
 * link: https://leetcode-cn.com/problems/truncate-sentence/
 * 1816. 截断句子
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s 和一个整数 k ，请你将 s 截断，使截断后的句子仅含前 k 个单词。返回截断 s 后得到的句子。
 *
 * 示例 1：
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 *
 * 示例 2：
 * 输入：s = "What is the solution to this problem", k = 4
 * 输出："What is the solution"
 * 解释：
 * s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
 * 前 4 个单词为 ["What", "is", "the", "solution"]
 * 因此，应当返回 "What is the solution"
 */
public class LeetCode1816 {

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }

    /**\
     * 我的方法
     * 执行用时: 2 ms     我的提交执行用时超过了33%的java 提交记录
     * 内存消耗: 37.1 MB  我的提交消耗内存超过了26%的java 提交记录
     */
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
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：36.4 MB, 在所有 Java 提交中击败了84.60%的用户
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
