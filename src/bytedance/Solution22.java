package bytedance;

/**
 * 环形链表 II https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1023/
 *
 * @author CaoJing
 * @date 2019/11/12 09:18
 */
public class Solution22 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36255162/
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
