package bytedance;

/**
 * 最大子序和 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1029/
 *
 * @author CaoJing
 * @date 2019/11/12 10:07
 */
public class Solution30 {

    /**
     * 题解 https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
     */
    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // 用时最快 https://leetcode-cn.com/submissions/detail/36262090/

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
