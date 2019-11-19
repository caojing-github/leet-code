package bytedance;

/**
 * 岛屿的最大面积 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1034/ TODO
 *
 * @author CaoJing
 * @date 2019/11/11 23:11
 */
public class Solution9 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36241633/
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int weight = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < weight; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(getAreaOfIsLand(grid, i, j), maxArea);
                }
            }
        }

        return maxArea;
    }

    private static int getAreaOfIsLand(int[][] grid, int row, int weight) {
        // 防止数组下标越界
        if (row < 0 || row >= grid.length) {
            return 0;
        } else if (weight < 0 || weight >= grid[0].length) {
            return 0;
        }

        if (grid[row][weight] == 1) {
            grid[row][weight] = 0; // 标记为以搜索过
            return 1 + getAreaOfIsLand(grid, row - 1, weight) + getAreaOfIsLand(grid, row + 1, weight) +
                getAreaOfIsLand(grid, row, weight - 1) + getAreaOfIsLand(grid, row, weight + 1);

        }
        return 0;
    }
}