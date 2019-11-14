package bytedance;

import java.util.LinkedList;
import java.util.List;

/**
 * **容易**
 * <p>
 * 二叉树的锯齿形层次遍历 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1027/
 *
 * @author CaoJing
 * @date 2019/11/12 09:43
 */
public class Solution26 {

    public static class TreeNode {
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 存放遍历结果
        List<List<Integer>> result = new LinkedList<>();
        // 存放每层元素
        LinkedList<TreeNode> list = new LinkedList<>();
        if (root != null) {
            list.add(root);
        }
        // true表示从左向右添加元素,false表示从右向左添加元素，将下面的流程用图画出来就很清晰
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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(t1));
    }
}
