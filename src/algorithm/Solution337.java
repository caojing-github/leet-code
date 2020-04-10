package algorithm;

import binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III https://leetcode-cn.com/problems/house-robber-iii/
 *
 * @author CaoJing
 * @date 2019/12/09 09:46
 */
public class Solution337 {

    Map<TreeNode, Integer> memo = new HashMap<>();

    /**
     * https://leetcode-cn.com/problems/house-robber-ii/solution/tong-yong-si-lu-tuan-mie-da-jia-jie-she-wen-ti-by-/
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        // 抢，然后去下下家
        int do_it = root.val
            // 沿左子树方向抢劫
            + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
            // 沿右子树方向抢劫
            + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        // 不抢，然后去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }
}
