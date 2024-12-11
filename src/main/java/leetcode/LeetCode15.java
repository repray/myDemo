package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Li Yang
 * @date: 2024-12-11
 * @description: https://leetcode.cn/problems/3sum/description/
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class LeetCode15 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }

    /**
     * 测试用例超时,待修改
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int k = 0; k < nums.length; k++) {
            int targetNum = nums[k];
            for (int i = 1; i < list.size(); i++) {
                for (int j = 2; j < list.size(); j++) {
                    if (i != j && j != k && i != k && list.get(i) + list.get(j) + targetNum == 0) {
                        List<Integer> integerList = new ArrayList<>();
                        integerList.add(targetNum);
                        integerList.add(list.get(i));
                        integerList.add(list.get(j));
                        integerList = integerList.stream().sorted().collect(Collectors.toList());
                        if (!resultList.contains(integerList)) {
                            resultList.add(integerList);
                        }
                    }
                }
            }
        }
        return resultList;
    }
}
