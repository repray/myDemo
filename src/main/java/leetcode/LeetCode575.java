package leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author : liyang
 * @date : 2021/11/1
 * https://leetcode-cn.com/problems/distribute-candies/
 */
public class LeetCode575 {

    public static void main(String[] args) {
        int[] candyType = new int[]{6, 6, 6, 6};
        System.out.println(distributeCandies(candyType));
    }

    public static int distributeCandies(int[] candyType) {
        Set candyTypeSort = new TreeSet();
        int i = 0;
        while (candyTypeSort.size() < candyType.length / 2 && i < candyType.length) {
            candyTypeSort.add(candyType[i]);
            i++;
        }
        return candyType.length / 2 > candyTypeSort.size() ? candyTypeSort.size() : candyType.length / 2;
    }
}
