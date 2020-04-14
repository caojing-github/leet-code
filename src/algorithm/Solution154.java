package algorithm;

/**
 * 寻找旋转排序数组中的最小值 II https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @author CaoJing
 * @date 2019/12/09 09:46
 */
public class Solution154 {

    /**
     * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-by-liweiwei1419/
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            // int mid = left + (right - left) / 2;
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                assert nums[mid] == nums[right];
                right--;
            }
        }
        return nums[left];
    }
}
