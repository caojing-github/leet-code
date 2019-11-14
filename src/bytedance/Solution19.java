package bytedance;

/**
 * **容易**
 * <p>
 * 反转链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1038/
 *
 * @author CaoJing
 * @date 2019/11/12 00:48
 */
public class Solution19 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36248544/
     */
    public static ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        // 链表1->2->3->4->5->NULL
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = reverseList(l1);
        System.out.println(l2);
    }
}
