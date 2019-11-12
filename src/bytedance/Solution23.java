package bytedance;

/**
 * 相交链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1024/
 *
 * @author CaoJing
 * @date 2019/11/12 09:25
 */
public class Solution23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36255586/
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (true) {
            if (a != null) {
                lengthA++;
                a = a.next;
            }
            if (b != null) {
                lengthB++;
                b = b.next;
            }
            if (a == null && b == null)
                break;
        }
        a = headA;
        b = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                a = a.next;
            }
        }
        if (lengthA < lengthB) {
            for (int i = 0; i < lengthB - lengthA; i++) {
                b = b.next;
            }
        }
        while (a != null && b != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
