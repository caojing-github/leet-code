package bytedance;

/**
 * 最大子序和 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1029/   TODO
 *
 * @author CaoJing
 * @date 2019/11/12 10:07
 */
public class Solution30 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36262090/
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
