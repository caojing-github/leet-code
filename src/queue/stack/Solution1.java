package queue.stack;

/**
 * 设计循环队列 https://leetcode-cn.com/explore/learn/card/queue-stack/216/queue-first-in-first-out-data-structure/865/
 *
 * @author CaoJing
 * @date 2019/12/09 09:46
 */
public class Solution1 {

    /**
     * https://leetcode-cn.com/submissions/detail/39357593/
     */
    private int[] queue;
    private int head;
    private int tail;
    private int count;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public Solution1(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;
        count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (count == queue.length) {
            return false;
        }
        tail++;
        if (tail == queue.length) {
            tail = 0;
        }
        if (head == -1) {
            head++;
        }
        queue[tail] = value;
        count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        head++;
        if (head == queue.length) {
            head = 0;
        }
        count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (count == 0) {
            return -1;
        }
        return queue[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return queue[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == queue.length;
    }
}
