package binarytree;

/**
 * 对称二叉树 https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/13/
 *
 * @author CaoJing
 * @date 2019/12/07 15:56
 */
public class Solution6 {

    /**
     * https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode/
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }
}
