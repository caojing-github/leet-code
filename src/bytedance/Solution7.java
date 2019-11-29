package bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原IP地址 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1044/
 *
 * @author CaoJing
 * @date 2019/11/11 22:55
 */
public class Solution7 {

    int n;
    String s;
    LinkedList<String> segments = new LinkedList<>();
    ArrayList<String> output = new ArrayList<>();

    /**
     * 回溯(DFS) https://leetcode-cn.com/problems/restore-ip-addresses/solution/fu-yuan-ipdi-zhi-by-leetcode/
     * 提交答案详情：https://leetcode-cn.com/submissions/detail/36240326/
     */
    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

    /**
     * @param prevPos 上一个放置的点
     * @param dots    待放置点的数量
     */
    public void backtrack(int prevPos, int dots) {
        int maxPos = Math.min(n - 1, prevPos + 4);
        // 遍历三个有效位置curr_pos以放置点
        for (int currPos = prevPos + 1; currPos < maxPos; currPos++) {
            String segment = s.substring(prevPos + 1, currPos + 1);

//            System.out.println(String.format("上一指针:%s,对应元素:%s,当前指针:%s对应元素:%s,中间的元素:%s",
//                prevPos, prevPos == -1 ? "无" : s.charAt(prevPos), currPos, currPos == -1 ? "无" : s.charAt(currPos), segment));

            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0) {
                    updateOutput(currPos);
                } else {
                    backtrack(currPos, dots - 1);
                }
                segments.removeLast();
            }
        }
    }

    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public void updateOutput(int currPos) {
        String segment = s.substring(currPos + 1, n);
        System.out.println(String.join(".", segments) + "." + segment);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution7 r = new Solution7();
        System.out.println(r.restoreIpAddresses("25525511135"));
    }
}
