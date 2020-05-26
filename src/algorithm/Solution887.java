package algorithm;

/**
 * 鸡蛋掉落 https://leetcode-cn.com/problems/super-egg-drop/
 *
 * @author CaoJing
 * @date 2019/12/09 09:46
 */
public class Solution887 {

    /**
     * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/gao-lou-reng-ji-dan-jin-jie
     */
    static int superEggDrop(int K, int N) {
        // m 最多不会超过 N 次（线性扫描）
        int[][] dp = new int[K + 1][N + 1];
        // base case:
        // dp[0][..] = 0
        // dp[..][0] = 0
        // Java 默认初始化数组都为 0
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(2, 10));
        System.out.println(superEggDrop(2, 11));
        System.out.println(superEggDrop(2, 12));
        System.out.println(superEggDrop(2, 13));
        System.out.println(superEggDrop(2, 14));
        System.out.println(superEggDrop(2, 15));
        System.out.println(superEggDrop(2, 16));
        System.out.println(superEggDrop(2, 18));
        System.out.println(superEggDrop(2, 19));
        System.out.println(superEggDrop(2, 20));
    }
}
