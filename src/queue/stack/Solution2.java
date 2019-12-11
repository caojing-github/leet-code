package queue.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量（BFS） https://leetcode-cn.com/explore/learn/card/queue-stack/217/queue-and-bfs/872/
 *
 * @author CaoJing
 * @date 2019/12/10 22:32
 */
public class Solution2 {

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
                    grid[r][c] = '0';

                    Queue<Integer> neighbors = new LinkedList<>();
                    // 可以看做函数 或者 辗转相除法表示两个数（结合后面的就能很快看明白）
                    neighbors.add(r * nc + c);

                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        // 高度
                        int row = id / nc;
                        // 宽度
                        int col = id % nc;

                        // 向上搜索
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        // 向下搜索
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        // 向左搜索
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        // 向右搜索
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}
