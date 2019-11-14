package bytedance;

/**
 * **容易**
 * <p>
 * 二叉树的最近公共祖先 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1026/
 *
 * @author CaoJing
 * @date 2019/11/12 09:36
 */
public class Solution25 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36258958/
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        // 示例1：https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1026/
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(1);
        t1.left.left = new TreeNode(6);
        t1.left.right = new TreeNode(2);
        t1.right.left = new TreeNode(0);
        t1.right.right = new TreeNode(8);
        t1.left.right.left = new TreeNode(7);
        t1.left.right.right = new TreeNode(4);

        // p=5,q=1
        TreeNode t2 = lowestCommonAncestor(t1, t1.left, t1.right);
        System.out.println(t2);
    }
}
