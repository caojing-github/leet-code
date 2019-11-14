package bytedance;

/**
 * 排序链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1040/ TODO
 *
 * @author CaoJing
 * @date 2019/11/12 09:13
 */
public class Solution21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36254634/
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int val = head.val;
        ListNode left = new ListNode(-1);
        ListNode mid = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode l = left, m = mid, r = right;
        while (head != null) {
            if (head.val < val) {
                l.next = head;
                l = l.next;
            } else if (head.val > val) {
                r.next = head;
                r = r.next;
            } else {
                m.next = head;
                m = m.next;
            }
            head = head.next;
        }
        l.next = null;
        r.next = null;
        left.next = sortList(left.next);
        right.next = sortList(right.next);
        l = left;
        while (l.next != null) l = l.next;
        l.next = mid.next;
        m.next = right.next;
        return left.next;
    }

}
