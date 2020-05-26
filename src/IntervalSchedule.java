import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法之区间调度问题 https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tan-xin-suan-fa-zhi-qu-jian-tiao-du-wen-ti
 *
 * @author CaoJing
 * @date 2020/05/22 14:16
 */
public class IntervalSchedule {

    /**
     * 区间调度算法
     */
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) {
            return 0;
        }
        // 按 end 升序排序
        Arrays.sort(intvs, Comparator.comparingInt(a -> a[1]));

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];

        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
