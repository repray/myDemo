package leetcode;

/**
 * @Author Li Yang
 * @Created on 20/2/2022.
 * link: https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * @Desc 717. 1比特与2比特字符
 */
public class LeetCode717 {
    public static void main(String[] args) {
        int[] bits = {1, 0};
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int N = bits.length;
        int pos = 0;
        while (pos < N - 1) {
            pos += bits[pos] == 1 ? 2 : 1;
        }
        return pos == N - 1;
    }
}
