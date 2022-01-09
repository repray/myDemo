package leetcode;

/**
 * @Author Li Yang
 * @Created on 31/12/2021.
 * @Desc 507. 完美数
 * link: https://leetcode-cn.com/problems/perfect-number/
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * <p>
 * 输入：num = 28
 * 输出：true
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。
 */
public class LeetCode507 {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(8128));
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum = sum+ i;
            }
        }
        if (sum == num) {
            return true;
        } else {
            return false;
        }
    }


}
