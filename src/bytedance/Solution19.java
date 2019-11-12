package bytedance;

/**
 * 反转链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1038/
 *
 * @author CaoJing
 * @date 2019/11/12 00:48
 */
public class Solution19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36248544/
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
