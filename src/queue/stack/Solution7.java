package queue.stack;

import java.util.Stack;

/**
 * 逆波兰表达式求值 https://leetcode-cn.com/explore/learn/card/queue-stack/218/stack-last-in-first-out-data-structure/880/
 *
 * @author CaoJing
 * @date 2019/12/10 22:23
 */
public class Solution7 {

    /**
     * 效率不是很高，但解题思路很清晰
     * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-19/
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                stack.push(stack.pop() / stack.pop());
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
