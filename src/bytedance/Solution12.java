package bytedance;

/**
 * 数组中的第K个最大元素
 *
 * @author CaoJing
 * @date 2019/11/12 00:19
 */
public class Solution12 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247394/
     */
    public int findKthLargest(int[] nums, int k) {
        return quicksearch(nums, 0, nums.length - 1, k);
    }

    private int quicksearch(int[] nums, int left, int right, int k) {
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

//			if(j - left + 1 >= k) {
//				return quicksearch(nums, left, j, k);
//			}else if(i - left + 1 <= k){
//				return quicksearch(nums, i, right, k - i + left);
//			}else{
//				return nums[i - 1];
//			}

        if (j - left + 1 >= k) {
            return quicksearch(nums, left, j, k);
        } else if (i - left == k) {
            return nums[i - 1];
        } else {
            return quicksearch(nums, i, right, k - i + left);
        }
    }


    private void swap(int i, int j, int[] nums) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
