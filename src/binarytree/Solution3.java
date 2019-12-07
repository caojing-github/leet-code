package binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author CaoJing
 * @date 2019/12/02 17:32
 */
public class Solution3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 题解 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        t1.right.left = new TreeNode(3);

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.postorderTraversal(t1));
    }
}
