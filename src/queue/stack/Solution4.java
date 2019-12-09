package queue.stack;

/**
 * 完全平方数 https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/874/
 *
 * @author CaoJing
 * @date 2019/12/09 23:53
 */
public class Solution4 {

    /**
     * 效率不是很高，但解题思路很清晰
     * https://leetcode-cn.com/problems/perfect-squares/solution/hua-jie-suan-fa-279-wan-quan-ping-fang-shu-by-guan/
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
