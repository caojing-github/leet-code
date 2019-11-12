package bytedance;

/**
 * 买卖股票的最佳时机 II https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1043/
 *
 * @author CaoJing
 * @date 2019/11/12 09:50
 */
public class Solution28 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36260981/
     * <p>
     * 解题思路：
     * 1. 对于一段曲线，最大值为顶点-谷点。
     * 2. 对数组进行遍历，求取一段点的最小值，再求取一段点的最大值。将两者相减得到一段点的最大差值。
     * 3. 将多段点的最大差值相加，得到最的和
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int peak = 0;
        int valley = 0;
        int i = 0;
        while (i < prices.length - 1) {
            // 求得谷点
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            peak = prices[i];
            // 求得峰点
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

}
