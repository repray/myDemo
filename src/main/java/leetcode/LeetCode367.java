package leetcode;

/**
 * @author : liyang
 * @date : 2021/11/4
 * link: https://leetcode-cn.com/problems/valid-perfect-square/
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
