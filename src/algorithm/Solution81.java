package algorithm;

/**
 * 搜索旋转排序数组 II https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @author CaoJing
 * @date 2019/12/09 09:46
 */
public class Solution81 {

    /**
     * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/er-fen-cha-zhao-by-liweiwei1419/
     */
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int left = 0;
        int right = len - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    // 落在前有序数组里
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                // 让分支和上面分支一样
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                // 要排除掉左边界之前，先看一看左边界可以不可以排除
                if (nums[left] == target) {
                    return true;
                } else {
                    left = left + 1;
                }
            }

        }
        // 后处理，夹逼以后，还要判断一下，是不是 target
        return nums[left] == target;
    }
}
