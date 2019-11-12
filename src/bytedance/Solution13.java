package bytedance;

import java.util.Arrays;

/**
 * 最长连续序列
 *
 * @author CaoJing
 * @date 2019/11/12 00:22
 */
public class Solution13 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247534/
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}
