package binarytree;

/**
 * 路径总和 https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/14/
 *
 * @author CaoJing
 * @date 2019/12/07 17:29
 */
public class Solution7 {

    /**
     * https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode/
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return (sum == 0);
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
