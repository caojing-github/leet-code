package bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 朋友圈 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1036/
 *
 * @author CaoJing
 * @date 2019/11/12 00:28
 */
public class Solution15 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247783/
     * 官方题解：https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
     */
    public static int findCircleNum(int[][] m) {
        int[] visited = new int[m.length];
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            if (visited[i] == 0) {
                dfs(m, visited, i);
                count++;
            }
        }
        return count;
    }

    /**
     * 深度优先搜索 https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
     */
    public static void dfs(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(m, visited, j);
            }
        }
    }

    /**
     * 广度优先搜索 https://leetcode-cn.com/problems/friend-circles/solution/peng-you-quan-by-leetcode/
     */
    public int findCircleNum2(int[][] m) {
        int[] visited = new int[m.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < m.length; j++) {
                        if (m[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] m = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(m));

        int[][] n = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };
        System.out.println(findCircleNum(n));

        int[][] p = {
            {1, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1},
        };
        System.out.println(findCircleNum(p));
    }
}
