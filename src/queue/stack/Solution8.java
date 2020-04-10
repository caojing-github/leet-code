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
        int H = grid.length;
        // 宽度
        int W = grid[0].length;
        int numIslands = 0;
        // 按高度遍历
        for (int h = 0; h < H; ++h) {
            // 按宽度遍历
            for (int w = 0; w < W; ++w) {
                if (grid[h][w] == '1') {
                    ++numIslands;
                    dfs(grid, h, w);
                }
            }
        }
        return numIslands;
    }

    /**
     * @param grid 二维网格
     * @param h    高度
     * @param w    宽度
     */
    public void dfs(char[][] grid, int h, int w) {
        // 高度
        int H = grid.length;
        // 宽度
        int W = grid[0].length;

        if (h < 0 || w < 0 || h >= H || w >= W || grid[h][w] == '0') {
            return;
        }
        grid[h][w] = '0';
        // 向上搜索
        dfs(grid, h - 1, w);
        // 向下搜索
        dfs(grid, h + 1, w);
        // 向左搜索
        dfs(grid, h, w - 1);
        // 向右搜索
        dfs(grid, h, w + 1);
    }
}
