package bytedance;

/**
 * **难**
 * <p>
 * 最大正方形 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1028/
 *
 * @author CaoJing
 * @date 2019/11/12 10:01
 */
public class Solution29 {

    /**
     * num[height-1][width-1]对应height*width子矩形"最大正方形"的边长
     */
    static int[][] num;

    /**
     * 矩形内"最大正方形"的边长
     */
    static int area;

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36261372/
     * <p>
     * 思路：对于矩形的任意子矩形，定义：该子矩形内以右下角顶点为顶点的最大正方形为该子矩形的"最大正方形"
     * <p>
     * 可以参看官方题解：https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // 矩阵的高
        int height = matrix.length;
        // 矩阵的宽
        int width = matrix[0].length;
        num = new int[height][width];
        area = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                num[i][j] = -1;
            }
        }
        squareSearch(matrix, height, width);
        return area * area;
    }

    /**
     * 获得height*width子矩形"最大正方形"的边长（此处"最大正方形"定义见上面"思路"）
     */
    private static int squareSearch(char[][] matrix, int height, int width) {
        if (height < 1 || width < 1) {
            return 0;
        }
        if (num[height - 1][width - 1] != -1) {
            return num[height - 1][width - 1];
        }

        // 左半侧子矩形"最大正方形"的边长
        int left = squareSearch(matrix, height, width - 1);
        // 上半侧子矩形"最大正方形"的边长
        int upper = squareSearch(matrix, height - 1, width);
        // 左上角子矩形"最大正方形"的边长
        int upLeft = squareSearch(matrix, height - 1, width - 1);

        // 上面3个长度的最小值
        int min = Math.min(Math.min(left, upper), upLeft);

        // 右下角顶点为'0'则该子矩形"最大正方形"的边长为0
        if (matrix[height - 1][width - 1] == '0') {
            num[height - 1][width - 1] = 0;
        } else {
            // 该子矩形"最大正方形"的边长
            num[height - 1][width - 1] = min + 1;
            area = Math.max(num[height - 1][width - 1], area);
        }
        return num[height - 1][width - 1];
    }

    /**
     * 官方题解 https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
     * 方法二：动态规划
     */
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    /**
     * 官方题解 https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode/
     * 方法三：动态规划优化
     */
    public int maximalSquare3(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));

        char[][] matrix2 = {
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '1', '1', '1', '1'}
        };
        System.out.println(maximalSquare(matrix2));
    }
}
