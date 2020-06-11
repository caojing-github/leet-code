package queue.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * 用队列实现栈 https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/889/
 *
 * @author CaoJing
 * @date 2019/12/11 15:50
 */
public class Solution12 {

    /**
     * 其他方法 https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode/
     */
    private static List list;

    /**
     * Initialize your data structure here.
     */
    public Solution12() {
        list = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(list.size(), x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (list.size() > 0) {
            return (int) list.remove(list.size() - 1);
        }
        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (list.size() > 0) {
            return (int) list.get(list.size() - 1);
        }
        return -1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.size() == 0;
    }
}
