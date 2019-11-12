package bytedance;

/**
 * 接雨水 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1047/
 *
 * @author CaoJing
 * @date 2019/11/12 00:35
 */
public class Solution17 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36248064/
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        //思路：按列求雨水，当前列的雨水取决于【左边最高】和【右边最高列】中【较低的那一列】，若该列高于当前需要求的列，则累加至结果中
        int res = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;

        //需要的是left-1和right+1
        while (left <= right) {
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                if (height[left] < max_left) res += (max_left - height[left]);
                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                if (height[right] < max_right) res += (max_right - height[right]);
                right--;
            }
        }

        return res;
    }
}
