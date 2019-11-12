package bytedance;

/**
 * 买卖股票的最佳时机 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1042/
 *
 * @author CaoJing
 * @date 2019/11/12 09:47
 */
public class Solution27 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36259650/
     */
    public int maxProfit(int[] prices) {
        // 遍历所有所有卖出的天数可能获得的最大利润，然后选出这些最大利润的最大值
        // 第一天不可能卖出，从第二天开始看
        if (prices.length <= 1) return 0;
        int maxProfit = 0;  // 保存目前的最大收益
        int minPrice = prices[0];   // 第i天之前的最小值
        for (int i = 1; i < prices.length; i++) {
            if (minPrice >= prices[i]) {
                minPrice = prices[i];
                continue;
            } else {   //当前的最大利润=max（前面i天的最大利润，第i天的的最大利润）
                // maxProfit保存了前面i天的最大利润
                // 第i天的的最大利润 = 第i天的价格 - 前面i天的最低价格
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }
}
