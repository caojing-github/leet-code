package bytedance;

/**
 * 无重复字符的最长子串 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/     TODO
 */
public class Solution1 {

    /**
     * 用时最快的代码 https://leetcode-cn.com/submissions/detail/35358953/
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int leftIndex = 0;

        for (int i = 0; i < chars.length; i++) {
            for (int innerIndex = leftIndex; innerIndex < i; innerIndex++) {
                // 在索引leftIndex到i-1之间有字符和索引i处字符相等时
                if (chars[innerIndex] == chars[i]) {
                    // 长度等于maxLength和（索引leftIndex到i-1之间的距离）最大值
                    maxLength = Math.max(maxLength, i - leftIndex);
                    // leftIndex等于相等时的角标加一
                    leftIndex = innerIndex + 1;
                    break;
                }
            }
        }
        return Math.max(chars.length - leftIndex, maxLength);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}