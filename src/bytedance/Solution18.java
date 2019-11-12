package bytedance;

/**
 * 合并两个有序链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1048/
 *
 * @author CaoJing
 * @date 2019/11/12 00:44
 */
public class Solution18 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36248439/
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
}
