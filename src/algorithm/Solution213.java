package algorithm;

/**
 * 打家劫舍 II https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author CaoJing
 * @date 2019/12/09 09:46
 */
public class Solution213 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 首尾房间都不抢,这种情况下最优决策结果小于下面👇两种情况
        return Math.max(
            // 第一间房子被抢最后一间不抢
            rob(nums, 0, len - 2),
            // 最后一间房子被抢第一间不抢
            rob(nums, 1, len - 1)
        );
    }

    /**
     * 相当于nums[begin]~nums[end]元素构成的数组的打家劫舍 https://leetcode-cn.com/problems/house-robber/ 问题
     */
    private int rob(int[] nums, int begin, int end) {
        int[] dp = new int[end - begin + 2];
        dp[0] = 0;
        dp[1] = nums[begin];

        for (int i = 2; i <= end - begin + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[begin - 1 + i]);
        }
        return dp[end - begin + 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution213().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution213().rob(new int[]{0}));
    }

}
