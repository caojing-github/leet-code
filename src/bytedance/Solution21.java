package bytedance;

/**
 * 排序链表 https://leetcode-cn.com/explore/interview/card/bytedance/244/linked-list-and-tree/1040/
 * 用时最快 https://leetcode-cn.com/submissions/detail/36254634/
 *
 * @author CaoJing
 * @date 2019/11/12 09:13
 */
public class Solution21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 解答一：归并排序（递归法） https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 右边的链表
        ListNode tmp = slow.next;
        slow.next = null;
        // 左边的链表
        ListNode left = sortList(head);
        // 右边的链表
        ListNode right = sortList(tmp);
        // 可以看做是"最终排序结果"的指针
        ListNode h = new ListNode(0);
        // 最终结果
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    // 未看 解答二：归并排序（从底至顶直接合并） https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(6);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next.next.next = new ListNode(8);

        ListNode l2 = sortList(l1);
        System.out.println();
    }

}
