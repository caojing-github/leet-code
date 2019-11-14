package bytedance;

import java.util.Arrays;

/**
 * **容易**
 * <p>
 * 最长连续序列 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1019/
 *
 * @author CaoJing
 * @date 2019/11/12 00:22
 */
public class Solution13 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247534/
     */
    public static int longestConsecutive(int[] nums) {
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

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
