package bytedance;

/**
 * 数组中的第K个最大元素  https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1018/    TODO
 *
 * @author CaoJing
 * @date 2019/11/12 00:19
 */
public class Solution12 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247394/
     */
    public static int findKthLargest(int[] nums, int k) {
        return quicksearch(nums, 0, nums.length - 1, k);
    }

    private static int quicksearch(int[] nums, int left, int right, int k) {
        int mid = left + ((right - left) >> 1);
        int cur = nums[mid];
        int i = left, j = right;
        while (i <= j) {
            while (nums[i] > cur) {
                i++;
            }
            while (nums[j] < cur) {
                j--;
            }
            if (i <= j) {
                swap(i, j, nums);
                i++;
                j--;
            }
        }

        if (j - left + 1 >= k) {
            return quicksearch(nums, left, j, k);
        } else if (i - left == k) {
            return nums[i - 1];
        } else {
            return quicksearch(nums, i, right, k - i + left);
        }
    }

    /**
     * 将nums[i]和nums[j]交换
     */
    private static void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
