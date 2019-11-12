package bytedance;

import java.util.List;

/**
 * 三角形最小路径和 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1030/
 *
 * @author CaoJing
 * @date 2019/11/12 10:04
 */
public class Solution31 {

    int row;
    Integer[][] memo;

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36261621/
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return helper(0, 0, triangle);
    }

    public int helper(int level, int column, List<List<Integer>> triangle) {
        if (memo[level][column] != null) {
            return memo[level][column];
        }
        if (level == row - 1) {
            return memo[level][column] = triangle.get(level).get(column);
        }
        int left = helper(level + 1, column, triangle);
        int right = helper(level + 1, column + 1, triangle);
        return memo[level][column] = Math.min(left, right) + triangle.get(level).get(column);
    }
}
