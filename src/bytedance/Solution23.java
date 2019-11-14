package bytedance;

/**
 * **中间**
 * <p>
 * 相交链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1024/
 *
 * @author CaoJing
 * @date 2019/11/12 09:25
 */
public class Solution23 {

    public static class ListNode {
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
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 链表A的长度
        int lengthA = 0;
        // 链表B的长度
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
            if (a == null && b == null) {
                break;
            }
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
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    public static void main(String[] args) {

        // 示例1：https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1024/
        // 交叉节点
        ListNode intersectionNode = new ListNode(8);
        intersectionNode.next = new ListNode(4);
        intersectionNode.next.next = new ListNode(5);

        // 链表4->1->8->4->5
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = intersectionNode;

        // 链表5->0->1->8->4->5
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(1);
        l2.next.next.next = intersectionNode;

        ListNode l3 = getIntersectionNode(l1, l2);
        System.out.println(l3);
    }
}
