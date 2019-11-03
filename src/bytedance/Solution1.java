package bytedance;

/**
 * 无重复字符的最长子串 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */
public class Solution1 {

    /**
     * https://www.jianshu.com/p/0f728aad1c70
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();

        /**
         * hash[value]的值是第i个字符最近一次出现的（在字符串中）下标+1。
         * 比如'a'这个字符最近一次出现在下标为3的位置处（abcabcbb），那么hash[value]存储的是4
         * hash[]通过不断更新遇到的字符的下标信息来表示字符是否出现过 或 是否在当前窗口内
         */
        int[] hash = new int[128];
        int left = 0;
        int maxlen = 0;

        for (int i = 0; i < chs.length; i++) {
            // 得到ASCII码
            int value = chs[i];
            // 当前字符未出现过 or 当前字符的位置不在窗口中
            if (hash[value] == 0 || hash[value] < left) {
                maxlen = Math.max(maxlen, i - left + 1);
            } else {
                left = hash[value];
            }
            hash[value] = i + 1;
        }
        return maxlen;
    }

    /**
     * 用时最快的代码 https://leetcode-cn.com/submissions/detail/35358953/
     */
    public static int lengthOfLongestSubstring2(String s) {
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