package bytedance;

/**
 * 无重复字符的最长子串 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
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
                if (chars[innerIndex] == chars[i]) {
                    maxLength = Math.max(maxLength, i - leftIndex);
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