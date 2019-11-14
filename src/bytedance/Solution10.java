package bytedance;

/**
 * **中等** 归纳类型
 * <p>
 * 搜索旋转排序数组 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1017/
 *
 * @author CaoJing
 * @date 2019/11/11 23:14
 */
public class Solution10 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36242392/
     * <p>
     * 思路可以参考：https://www.cnblogs.com/ariel-dreamland/p/9138064.html
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) >> 1;

            if (nums[mid] == target) {
                return mid;
            }

            /**
             * 0　　1　　2　　4　　5　　6　　7
             * 4　　5　　6　　7　　0　　1　　2
             * 2　　4　　5　　6　　7　　0　　1
             * 1　　2　　4　　5　　6　　7　　0
             */
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

                /**
                 * 7　　0　　1　　 2　　4　　5　　6
                 * 6　　7　　0　　 1　　2　　4　　5
                 * 5　　6　　7　　 0　　1　　2　　4
                 */
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{7, 0, 1, 2, 4, 5, 6}, 7));
    }
}
