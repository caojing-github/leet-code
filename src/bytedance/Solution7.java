package bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1044/
 *
 * @author CaoJing
 * @date 2019/11/11 22:55
 */
public class Solution7 {

    public String s;
    public int[] path;
    List<String> ans;

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36240326/
     */
    public List<String> restoreIpAddresses(String _s) {
        ans = new ArrayList<>();
        // return new ArrayList<>();
        s = _s;
        path = new int[5];
        path[4] = s.length();
        dfs(0, 0);
        return ans;
    }

    public void dfs(int beg, int cnt) {
        if (cnt == 4) {
            if (beg != s.length())
                return;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(s.substring(path[i], path[i + 1]));
                if (i != 3)
                    sb.append(".");
            }
            ans.add(sb.toString());
            return;
        }
        if ((s.length() - beg) > 3 * (4 - cnt) || (s.length() - beg) < 1 * (4 - cnt))
            return;
        if (s.charAt(beg) != '0') {
            path[cnt] = beg;
            dfs(beg + 1, cnt + 1);
            if (beg + 1 < s.length()) {
                dfs(beg + 2, cnt + 1);
            }
            if (beg + 2 < s.length()) {
                if (((s.charAt(beg) - '0') * 100 + (s.charAt(beg + 1) - '0') * 10 + s.charAt(beg + 2) - '0') < 256)
                    dfs(beg + 3, cnt + 1);
            }
        } else {
            path[cnt] = beg;
            dfs(beg + 1, cnt + 1);
        }

        return;
    }

    public static void main(String[] args) {
        Solution7 r = new Solution7();
        /*String rss="25525511135";
        for (int i = 0; i <=rss.length() ; i++) {
            System.out.println(rss.substring(0,i));
        }*/
        System.out.println(r.restoreIpAddresses("010010"));
    }
}
