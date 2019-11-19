package bytedance;

/**
 * 两数相加 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1022/ TODO
 *
 * @author CaoJing
 * @date 2019/11/12 09:08
 */
public class Solution20 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36254231/
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode pre = null;
        ListNode res = l1;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                l1 = l2;
                l2 = null;
            }
            l1.val += (l2 == null) ? c : (l2.val + c);
            c = 0;
            if (l1.val > 9) {
                l1.val %= 10;
                c = 1;
            }
            pre = l1;
            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (c != 0) {
            ListNode hi = new ListNode(1);
            pre.next = hi;
        }
        return res;
    }

    public static void main(String[] args) {
        // 链表2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 链表5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = addTwoNumbers(l1, l2);
        System.out.println(l3);
    }
}