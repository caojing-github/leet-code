package bytedance;

/**
 * 简化路径 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1013/   TODO
 *
 * @author CaoJing
 * @date 2019/11/11 22:50
 */
public class Solution6 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36239510/
     */
    public static String simplifyPath(String path) {
        char[] cs = path.toCharArray();
        int n = cs.length;
        int idx = 0;
        int i = 0;
        while (i < n) {
            if (cs[i] != '/' && (cs[i] != '.' || (i < n - 1 && cs[i + 1] != '/' && (cs[i + 1] != '.' || (i < n - 2 && cs[i + 2] != '/'))))) {
                cs[idx++] = '/';
                while (i < n && cs[i] != '/') cs[idx++] = cs[i++];
            } else if (cs[i] == '.' && i > 0 && cs[i - 1] == '.') {
                while (idx > 0 && cs[--idx] != '/') ;
                i++;
            } else i++;
        }
        if (idx == 0) return "/";
        return new String(cs, 0, idx);
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

}
