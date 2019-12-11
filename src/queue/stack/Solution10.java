package queue.stack;

/**
 * 目标和 https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/885/
 *
 * @author CaoJing
 * @date 2019/12/11 11:34
 */
public class Solution10 {

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }

    /**
     * 效率不是很高，但解题思路很清晰
     * https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
     *
     * @param nums 数组
     * @param i    待处理的元素角标
     * @param sum  累计和
     * @param S    目标和
     */
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) {
                count++;
            }
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}
