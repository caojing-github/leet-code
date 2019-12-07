package binarytree;

/**
 * 填充每个节点的下一个右侧节点指针 https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/17/
 *
 * @author CaoJing todo
 * @date 2019/12/07 21:07
 */
public class Solution10 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
