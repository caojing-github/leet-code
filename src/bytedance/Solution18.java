package bytedance;

/**
 * **容易**
 * <p>
 * 合并两个有序链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1048/
 *
 * @author CaoJing
 * @date 2019/11/12 00:44
 */
public class Solution18 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36248439/
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        // 有序链表1->2->4
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // 有序链表1->3->4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // 合并后的结果
        ListNode l3 = mergeTwoLists(l1, l2);
        System.out.println(l3);
    }
}
