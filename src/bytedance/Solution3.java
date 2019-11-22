package bytedance;


/**
 * 字符串的排列   https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/
 *
 * @author CaoJing
 * @date 2019/11/10 19:41
 */
public class Solution3 {

    /**
     * 方法五 滑动窗口法 https://leetcode-cn.com/problems/permutation-in-string/solution/zi-fu-chuan-de-pai-lie-by-leetcode/
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map)) {
                return true;
            }
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) {
                return false;
            }
        }
        return true;
    }

    // 用时最快的代码 https://leetcode-cn.com/submissions/detail/36112689/

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
