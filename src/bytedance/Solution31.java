package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * **容易**
 * <p>
 * 三角形最小路径和 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1030/
 *
 * @author CaoJing
 * @date 2019/11/12 10:04
 */
public class Solution31 {

    // 行数
    private static int row;
    private static Integer[][] memo;

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36261621/
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new Integer[row][row];
        return helper(0, 0, triangle);
    }

    /**
     * 第level行第column列到第(level + 1)行最小路径和
     *
     * @param level    第level行
     * @param column   第column列
     * @param triangle 三角形
     */
    public static int helper(int level, int column, List<List<Integer>> triangle) {
        if (memo[level][column] != null) {
            return memo[level][column];
        }
        if (level == row - 1) {
            return memo[level][column] = triangle.get(level).get(column);
        }
        // 第(level + 1)行第column列到第(level + 2)行最小路径和
        int left = helper(level + 1, column, triangle);
        // 第(level + 1)行第(column + 1)列到第(level + 2)行最小路径和
        int right = helper(level + 1, column + 1, triangle);
        return memo[level][column] = Math.min(left, right) + triangle.get(level).get(column);
    }

    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);

        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);

        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);

        System.out.println(minimumTotal(triangle));
    }
}
