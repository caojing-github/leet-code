package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1046/
 *
 * @author CaoJing
 * @date 2019/11/12 00:31
 */
public class Solution16 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247949/
     * 官方题解没有下面题解效率高
     * 题解 https://leetcode-cn.com/problems/merge-intervals/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-40/
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);// a[0] - b[0]大于0就交换顺序
        // 根据二维数组第一个数字大小按每一行整体排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // i不能到最后一行,所以要小于(数组的长度 - 1)
            // 判断所在行的right和下一行的left大小,对right重新进行赋最大值,之后再不断进行while循环判断
            while (i < intervals.length - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
