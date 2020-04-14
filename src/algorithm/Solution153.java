package algorithm;

/**
 * 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * @author CaoJing
 * @date 2019/12/09 09:46
 */
public class Solution153 {

    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-java-dai-ma-by-/
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            throw new IllegalArgumentException("数组为空，无最小元素");
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // 因为题目中说：你可以假设数组中不存在重复元素。
                // 此时一定有 nums[mid] < nums[right]
                right = mid;
            }
        }
        // 一定存在最小元素，因此无需再做判断
        return nums[left];
    }
}
