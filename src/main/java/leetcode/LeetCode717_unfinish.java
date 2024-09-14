package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Li Yang
 * @Created on 20/2/2022.
 * link: https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * @Desc 717. 1比特与2比特字符
 */
public class LeetCode717_unfinish {
    public static void main(String[] args) {
        int[] bits = {1,0};
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        List<Integer> list = Arrays.stream(bits).boxed().collect(Collectors.toList());
        if (list.size()==1&&list.get(0)==0) return true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1 && list.get(i + 1) == 1) {
                list.remove(i);
                list.remove(i);
                i += 1;
                continue;
            }
            if (list.get(i) == 1 && list.get(i + 1) == 0) {
                list.remove(i);
                list.remove(i);
                i += 1;
                continue;
            }
            if (list.get(i) == 0) {
                list.remove(i);
            }
        }
        if (list.get(0) != 0) {
            return false;
        } else
            return true;
    }
}
