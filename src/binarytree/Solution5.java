package binarytree;

/**
 * 二叉树的最大深度 https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/12/
 *
 * @author CaoJing
 * @date 2019/12/07 15:37
 */
public class Solution5 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode/
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
