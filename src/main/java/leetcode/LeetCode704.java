package leetcode;

/**
 * @author : liyang
 * @date : 2021/9/6
 * link: https://leetcode-cn.com/problems/binary-search/
 */
public class LeetCode704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = -2;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;

        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                head = mid + 1;
            } else if (nums[mid] > target) {
                tail = mid - 1;
            }
        }
        return -1;
    }
}
