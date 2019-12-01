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
     * 题解 https://www.jiuzhang.com/solution/russian-doll-envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0
            || envelopes[0] == null || envelopes[0].length != 2) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -index - 1;
            }
            dp[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }
        return len;
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
