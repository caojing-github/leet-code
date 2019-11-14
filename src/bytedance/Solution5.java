package bytedance;

/**
 * **容易**
 * <p>
 * 翻转字符串里的单词 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1011/
 *
 * @author CaoJing
 * @date 2019/11/11 22:42
 */
public class Solution5 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36238670/
     */
    public static String reverseWords(String s) {
        if (s == null || s.isEmpty())
            return s;
        s = s.trim();
        String[] charArray = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i].equals(""))
                continue;
            res.append(charArray[i]);
            if (i != 0)
                res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("he sky is blue"));
    }
}
