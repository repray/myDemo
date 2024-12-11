package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author: Li Yang
 * @date: 2024-12-11
 * @description: https://leetcode.cn/problems/kth-largest-element-in-an-array/description/
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
public class LeetCode215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findTargetNum(nums, 4));
    }

    private static int findTargetNum(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int array : nums) {
            list.add(array);
        }
        list = list.stream().sorted().collect(Collectors.toList());
        return list.get(list.size() - k);
    }
}
