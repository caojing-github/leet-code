package bytedance;

/**
 * 朋友圈 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1036/
 *
 * @author CaoJing
 * @date 2019/11/12 00:28
 */
public class Solution15 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247783/
     */
    public int findCircleNum(int[][] m) {
        int res = 0;
        int[] mark = new int[m.length];

        for (int i = 0; i < m.length; i++) {
            if (mark[i] == 0) {
                DFS(i, m, mark);
                res++;
            }
        }

        return res;
    }

    public void DFS(int i, int[][] m, int[] mark) {
        mark[i] = 1;

        for (int j = 0; j < m[i].length; j++) {
            if (mark[j] == 0 && m[i][j] == 1) {
                DFS(j, m, mark);
            }
        }
    }
}
