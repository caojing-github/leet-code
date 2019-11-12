package bytedance;

/**
 * 最长连续递增序列 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1035/
 *
 * @author CaoJing
 * @date 2019/11/12 00:17
 */
public class Solution11 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36247304/
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 1;
            }
        }
        max = Math.max(count, max);
        return max;
    }
}
