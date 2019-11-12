package bytedance;

/**
 * 第k个排列 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1021/
 *
 * @author CaoJing
 * @date 2019/11/12 00:25
 */
public class Solution14 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247637/
     */
    public String getPermutation(int n, int k) {
        char[] ret = new char[n];
        for (int i = 0; i < n; i++) {
            ret[i] = (char) (i + '1');
        }
        int[] pows = new int[n + 1];
        pows[1] = 1;
        for (int i = 2; i <= n; i++) {
            pows[i] = pows[i - 1] * i;
        }

        getPermutation(ret, pows, 0, k - 1);
        return new String(ret);
    }

    public void getPermutation(char[] ret, int[] pows, int bg, int k) {
        if (bg >= ret.length) {
            return;
        }
        int x = ret.length - bg;
        if (k / pows[x] == 0) {
            getPermutation(ret, pows, bg + 1, k);
        } else {
            int t = k / pows[x];
            fetch(ret, bg + t, bg);
            getPermutation(ret, pows, bg + 1, k % pows[x]);
        }
    }

    public void fetch(char[] ret, int from, int to) {
        from -= 1;
        to -= 1;
        char c = ret[from];
        for (int i = from; i > to; i--) {
            ret[i] = ret[i - 1];
        }
        ret[to] = c;
    }
}
