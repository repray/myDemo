package leetcode;

/**
 * @author : liyang
 * @date : 2021/11/4
 * 367. 有效的完全平方数
 * link: https://leetcode-cn.com/problems/valid-perfect-square/
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * 提示：
 * 1 <= num <= 2^31 - 1
 */
public class LeetCode367 {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(8));
    }

    public static boolean isPerfectSquare(int num) {
        int result = (int) Math.sqrt(num);
        return result * result == num;
    }
}
