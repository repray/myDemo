package leetcode;

/**
 * @author : liyang
 * @date : 2021/11/23
 * 859. 亲密字符串
 * link: https://leetcode-cn.com/problems/buddy-strings/
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回true；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * 示例 1：
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * <p>
 * 示例 2：
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * <p>
 * 示例 3：
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * <p>
 * 示例 4：
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 */
public class LeetCode859 {

    public static void main(String[] args) {
//        String s = "aaaaaaabc";
//        String goal = "aaaaaaacb";
        String s = "ab";
        String goal = "ca";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        //如果长度不相等,则返回false
        if (s.length() != goal.length()) {
            return false;
        } else if (s.equals(goal)) {
            //如果s等于goal,则s或goal中有重复的元素则,说明s和goal为亲密字符串,举例.abcd 和abcd 无论如何变化,abcd都不会等于变化后的abcd,abca和abca,则可以在第一位和第四位的a调整位置后得到
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (s.indexOf(c) != s.lastIndexOf(c)) {
                    return true;
                }
            }
            return false;
        } else {
            int count = 0;
            String ss = "";
            String gg = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    ss = ss + s.charAt(i);
                    gg = gg + goal.charAt(i);
                    count++;
                }
            }
            if (count == 2) {
                if (ss.charAt(0) == gg.charAt(1) && ss.charAt(1) == gg.charAt(0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
