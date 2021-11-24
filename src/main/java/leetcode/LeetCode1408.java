package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author : liyang
 * @date : 2021/11/11
 * <p>
 * 1408. 数组中的字符串匹配
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 * 如果你可以删除 words[j]最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 * link: https://leetcode-cn.com/problems/string-matching-in-an-array/
 * <p>
 * 示例 1：
 * 输入：words = ["mass","as","hero","superhero"]
 * 输出：["as","hero"]
 * 解释："as" 是 "mass" 的子字符串，"hero" 是 "superhero" 的子字符串。
 * ["hero","as"] 也是有效的答案。
 * <p>
 * 示例 2：
 * 输入：words = ["leetcode","et","code"]
 * 输出：["et","code"]
 * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
 * <p>
 * 示例 3：
 * 输入：words = ["blue","green","bu"]
 * 输出：[]
 * <p>
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] 仅包含小写英文字母。
 * 题目数据 保证 每个 words[i] 都是独一无二的。
 */
public class LeetCode1408 {

    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};
        for (String s : stringMatching(words)) {
            System.out.println(s);
        }
    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了20.11%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了15.28%的用户
     * 代码执行用时,内存消耗都需要优化
     */
    public static List<String> stringMatching(String[] words) {
        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            set.add(word);
        }
        List<String> subset = new ArrayList<>();
        for (String s : set) {
            int num = 0;
            for (String word : words) {
                if (word.contains(s)) {
                    num++;
                }
            }
            if (num >= 2) {
                subset.add(s);
            }
        }
        return subset;
    }
}
