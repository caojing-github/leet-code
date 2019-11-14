package bytedance;


import java.util.Arrays;

/**
 * 字符串的排列   https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1016/   TODO
 *
 * @author CaoJing
 * @date 2019/11/10 19:41
 */
public class Solution3 {

    /**
     * 用时最快的代码 https://leetcode-cn.com/submissions/detail/36112689/
     */
    public static boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] used = new int['z' + 1];
        Arrays.fill(used, 0);
        for (int i = 0; i < c1.length; i++) {
            used[c1[i]]++;
        }
        int start = 0;
        for (int i = 0; i < c2.length; i++) {
            while (used[c2[i]] == 0) {
                used[c2[start]]++;
                start++;
            }
            used[c2[i]]--;
            if (i - start == c1.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
