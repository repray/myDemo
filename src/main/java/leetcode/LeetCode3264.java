package leetcode;

import java.util.Arrays;

/**
 * @author: Li Yang
 * @date: 2024-12-13
 * @description: 3264. K 次乘运算后的最终数组 I
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 * 示例 1：
 * 输入：nums = [2,1,3,5,6], k = 5, multiplier = 2
 * 输出：[8,4,6,5,6]
 * 操作	结果
 * 1 次操作后	[2, 2, 3, 5, 6]
 * 2 次操作后	[4, 2, 3, 5, 6]
 * 3 次操作后	[4, 4, 3, 5, 6]
 * 4 次操作后	[4, 4, 6, 5, 6]
 * 5 次操作后	[8, 4, 6, 5, 6]
 * 输入：nums = [1,2], k = 3, multiplier = 4
 * 输出：[16,8]
 * 操作	结果
 * 1 次操作后	[4, 2]
 * 2 次操作后	[4, 8]
 * 3 次操作后	[16, 8]
 */
public class LeetCode3264 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        System.out.println(Arrays.toString(getFinalState(nums, 5, 2)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int minNum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (minNum != j) {
                    if (nums[minNum] > nums[j]) {
                        minNum = j;
                    } else if (nums[minNum] == nums[j]) {
                        minNum = minNum < j ? minNum : j;
                    }
                }
            }
            int result = nums[minNum] * multiplier;
            nums[minNum] = result;
        }
        return nums;
    }
}
