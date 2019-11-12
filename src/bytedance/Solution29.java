package bytedance;

/**
 * 最大正方形 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1028/
 *
 * @author CaoJing
 * @date 2019/11/12 10:01
 */
public class Solution29 {

    static int[][] num;
    static int area;

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36261372/
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int length = matrix[0].length;
        num = new int[height][length];
        area = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                num[i][j] = -1;
            }
        }
        squareSearch(matrix, height - 1, length - 1);
        // for (int i = 0; i < num.length; i++) {
        // 	for(int j = 0 ; j < num[0].length;j++) {
        // 		System.out.print(num[i][j]+" ");
        // 	}
        // 	 System.out.println();
        // }
        return area * area;
    }

    private static int squareSearch(char[][] matrix, int height, int length) {
        if (height < 0 || length < 0) {
            return 0;
        }
        if (num[height][length] != -1) {
            return num[height][length];
        }

        int left = squareSearch(matrix, height, length - 1);
        int upper = squareSearch(matrix, height - 1, length);
        int upLeft = squareSearch(matrix, height - 1, length - 1);

        int min = Math.min(Math.min(left, upper), upLeft);

        if (matrix[height][length] == '0') {
            num[height][length] = 0;
        } else {
            num[height][length] = min + 1;
            area = Math.max(num[height][length], area);
        }
//		System.out.println(min);

        return num[height][length];


    }
}
