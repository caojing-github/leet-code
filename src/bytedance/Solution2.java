package bytedance;

/**
 * **容易**
 * <p>
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
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 0; i < strs.length; i++) {
            // 第一个字符串不是最长公共前缀
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
                if (result.length() == 0) {
                    return "";
                }
            }
        }
        return result;
    }
}
