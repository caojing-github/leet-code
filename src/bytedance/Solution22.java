package bytedance;

/**
 * **中等**
 * <p>
 * 环形链表 II https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1023/
 *
 * @author CaoJing
 * @date 2019/11/12 09:18
 */
public class Solution22 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36255162/
     * <p>
     * 思路参考：https://blog.csdn.net/Eartha1995/article/details/80990636
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        {
            // 示例1：https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1023/
            ListNode l1 = new ListNode(3);
            l1.next = new ListNode(2);
            l1.next.next = new ListNode(0);
            l1.next.next.next = new ListNode(-4);
            l1.next.next.next.next = l1.next;

            ListNode l2 = detectCycle(l1);
            System.out.println(l2);
        }

        {
            // 示例2
            ListNode l3 = new ListNode(1);
            l3.next = new ListNode(2);
            l3.next.next = l3;

            ListNode l4 = detectCycle(l3);
            System.out.println(l4);
        }

        {
            // 示例3
            ListNode l5 = new ListNode(1);

            ListNode l6 = detectCycle(l5);
            System.out.println(l6);
        }
    }
}
