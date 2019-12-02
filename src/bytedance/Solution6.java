package bytedance;

import java.util.Stack;

/**
 * 简化路径 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1013/
 *
 * @author CaoJing
 * @date 2019/11/11 22:50
 */
public class Solution6 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36239510/
     * 题解 https://leetcode-cn.com/problems/simplify-path/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-18/
     */
    public static String simplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals("..")) {
                stack.pop();
            } else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals("..")) {
                stack.push(s[i]);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/");
            res.append(stack.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

}
