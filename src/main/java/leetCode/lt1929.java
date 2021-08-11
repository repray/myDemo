package leetCode;


/**
 * @Author Li Yang
 * @Created on 2021/8/11.
 * @Desc 1929.数组串联 https://leetcode-cn.com/problems/concatenation-of-array/
 * @tips 力扣算法题通常不允许使用现成的工具类
 */
public class lt1929 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        System.out.println(getConcatenation(nums));
    }


    public static int[] getConcatenation(int[] nums) {
        //使用工具类解答,不通过
//        int[] both = ArrayUtils.addAll(nums, nums);
//        return both;

        int[] ans = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}
