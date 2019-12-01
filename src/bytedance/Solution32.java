package bytedance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * **难**
 * <p>
 * 俄罗斯套娃信封问题 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1031/
 *
 * @author CaoJing
 * @date 2019/11/12 10:11
 */
public class Solution32 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36262367/
     * 题解 https://leetcode-cn.com/problems/russian-doll-envelopes/solution/zui-chang-di-zeng-zi-xu-lie-kuo-zhan-dao-er-wei-er/
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                    b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    /**
     * 最长上升子序列  https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-she-ji-fang-fa-zhi-pai-you-xi-jia/
     * 下面的方法易于理解，链接中的'二分查找解法'仅供了解
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] envelopes = {
            {5, 4},
            {6, 5},
            {6, 7},
            {2, 3}
        };
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.maxEnvelopes(envelopes));
    }
}
