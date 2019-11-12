package bytedance;

/**
 * 合并区间 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1046/
 *
 * @author CaoJing
 * @date 2019/11/12 00:31
 */
public class Solution16 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247949/
     */
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        int mergeCount = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]) {
                    if (intervals[i][1] > intervals[j][1]) {
                        intervals[j][1] = intervals[i][1];
                    }
                    if (intervals[i][0] < intervals[j][0]) {
                        intervals[j][0] = intervals[i][0];
                    }
                    intervals[i] = null;
                    mergeCount++;
                    break;
                }
            }
        }
        int[][] result = new int[intervals.length - mergeCount][];
        for (int i = 0, j = 0; j < intervals.length; j++) {
            if (intervals[j] != null) {
                result[i++] = intervals[j];
            }
        }
        return result;
    }
}
