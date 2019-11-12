package bytedance;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1027/
 *
 * @author CaoJing
 * @date 2019/11/12 09:43
 */
public class Solution26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36259371/
     */
    //锯齿遍历/Z字形遍历（分层打印）
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) {
            list.add(root);
        }
        boolean rowflag = true;
        while (!list.isEmpty()) {
            int size = list.size();
            LinkedList<Integer> rownums = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = list.pollFirst();
                if (rowflag) {
                    rownums.add(p.val);
                } else {
                    rownums.addFirst(p.val);
                }
                if (p.left != null) {
                    list.add(p.left);
                }
                if (p.right != null) {
                    list.add(p.right);
                }
            }
            rowflag = !rowflag;
            result.add(rownums);
        }
        return result;
    }
}
