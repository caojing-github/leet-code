package bytedance;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */
public class Solution1 {

    /**
     * 推荐：滑动窗口，官方题解：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}