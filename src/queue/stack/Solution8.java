package queue.stack;

/**
 * 岛屿数量（DFS） https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/872/
 *
 * @author CaoJing
 * @date 2019/12/09 23:52
 */
public class Solution8 {

    /**
     * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 高度
        int nr = grid.length;
        // 宽度
        int nc = grid[0].length;
        int numIslands = 0;
        // 按高度遍历
        for (int r = 0; r < nr; ++r) {
            // 按宽度遍历
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c);
                }
            }
        }

        return numIslands;
    }

    /**
     * @param grid 二维网格
     * @param r    高度
     * @param c    宽度
     */
    public void dfs(char[][] grid, int r, int c) {
        // 高度
        int nr = grid.length;
        // 宽度
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        // 向上搜索
        dfs(grid, r - 1, c);
        // 向下搜索
        dfs(grid, r + 1, c);
        // 向左搜索
        dfs(grid, r, c - 1);
        // 向右搜索
        dfs(grid, r, c + 1);
    }
}
