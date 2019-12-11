package queue.stack;

import java.util.List;

/**
 * 克隆图 https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/884/
 *
 * @author CaoJing todo
 * @date 2019/12/11 10:54
 */
public class Solution9 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * https://leetcode-cn.com/problems/clone-graph/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-9/
     */
    public Node cloneGraph(Node node) {
        return null;
    }
}
