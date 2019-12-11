package queue.stack;

import java.util.Stack;

/**
 * 用栈实现队列 https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/888/
 *
 * @author CaoJing
 * @date 2019/12/11 15:12
 */
public class Solution11 {

    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    /**
     * Initialize your data structure here.
     */
    public Solution11() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackPush.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        } else {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
        return stackPop.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is empyt.");
        } else {
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }
        return stackPop.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }
}
