package bytedance;

import java.util.Stack;

/**
 * 接雨水 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1047/
 * 用时最快 https://leetcode-cn.com/submissions/detail/36248064/
 *
 * @author CaoJing
 * @date 2019/11/12 00:35
 */
public class Solution17 {

    /**
     * 方法一：暴力法
     * 官方题解 https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     */
    public static int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    /**
     * 方法二：动态编程
     * 官方题解 https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     */
    public static int trap2(int[] height) {
        if (height == null) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 不推荐看，仅供了解。方法二：栈的应用
     * 官方题解 https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     */
    public static int trap3(int[] height) {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                // 获取栈顶元素
                int top = st.peek();
                // 栈顶元素出栈
                st.pop();
                if (st.empty()) {
                    break;
                }
                int distance = current - st.peek() - 1;
                int boundedHeight = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * boundedHeight;
            }
            st.push(current++);
        }
        return ans;
    }

    /**
     * 未看，仅供了解。方法二：使用双指针
     * 官方题解 https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-by-leetcode/
     */
    public static int trap4(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += (leftMax - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += (rightMax - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
