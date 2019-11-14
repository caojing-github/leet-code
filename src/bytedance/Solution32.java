package bytedance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * **难**
 * <p>
 * 俄罗斯套娃信封问题 https://leetcode-cn.com/explore/interview/card/bytedance/246/dynamic-programming-or-greedy/1031/   TODO
 *
 * @author CaoJing
 * @date 2019/11/12 10:11
 */
public class Solution32 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36262367/
     */
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len < 2) {
            return len;
        }

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] envelope1, int[] envelope2) {
                if (envelope1[0] != envelope2[0]) {
                    return envelope1[0] - envelope2[0];
                }
                return envelope2[1] - envelope1[1];
            }
        });


        int[] tail = new int[len];
        tail[0] = envelopes[0][1];

        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < len; i++) {
            int target = envelopes[i][1];

            if (target > tail[end]) {
                end++;
                tail[end] = target;
            } else {
                int left = 0;
                int right = end;

                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (tail[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = target;
            }
        }
        return end + 1;
    }
}
