package bytedance;

import java.util.Arrays;

/**
 * **容易**
 * <p>
 * 最小栈 https://leetcode-cn.com/explore/interview/card/bytedance/245/data-structure/1049/
 *
 * @author CaoJing
 * @date 2019/11/12 10:14
 */
public class Solution33 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36263340/
     */
    int[] arr = new int[10];
    int index = 0;
    int min = Integer.MAX_VALUE;

    public Solution33() {
    }

    /**
     * 将元素 x 推入栈中
     */
    public void push(int x) {
        // 数组超过一半扩容
        if (index > (arr.length >> 1)) {
            arr = Arrays.copyOf(arr, arr.length << 1);
        }
        arr[index++] = x;
        if (min > x) {
            min = x;
        }
    }

    /**
     * 删除栈顶的元素
     */
    public void pop() {
        --index;
        if (arr[index] == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < index; ++i) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
        }
    }

    /**
     * 获取栈顶元素
     */
    public int top() {
        if (index > 0) {
            return arr[index - 1];
        } else {
            return 0;
        }
    }

    /**
     * 检索栈中的最小元素
     */
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Solution33 minStack = new Solution33();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());

        minStack.pop();

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}




