package bytedance;

/**
 * 最长公共前缀 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 *
 * @author CaoJing
 * @date 2019/11/10 01:11
 */
public class Solution2 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36111565/
     * https://www.jianshu.com/p/4ef3cfa01367
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.length() == 0) {
                    return "";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix3(strs));
    }
}
