package bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * **容易**
 * <p>
 * 三数之和 https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1020/
 *
 * @author CaoJing
 * @date 2019/11/11 23:03
 */
public class Solution8 {

    /**
     * 看一下了解一下，（不推荐）用时最快 https://leetcode-cn.com/submissions/detail/36241223/
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0, posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue) {
                minValue = v;
            }
            if (v > maxValue) {
                maxValue = v;
            }
            if (v > 0) {
                posSize++;
            } else if (v < 0) {
                negSize++;
            } else {
                zeroSize++;
            }
        }
        //输出 三个 0 的情况
        if (zeroSize >= 3) {
            res.add(Arrays.asList(0, 0, 0));
        }
        if (negSize == 0 || posSize == 0) {
            return res;
        }
        //此时minValue一定为负数，maxValue一定为正数
        //如果maxValue > -2*minValue，那么大于 -2*minValue的元素肯定不会是答案，可以排除掉，所以更新maxValue
        if (minValue * 2 + maxValue > 0) {
            maxValue = -minValue * 2;
            //同理更新minValue
        } else if (maxValue * 2 + minValue < 0) {
            minValue = -maxValue * 2;
        }
        //自己构建一个hashmap，值表示元素重复次数，注意java数组默认值为 0
        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            //只保留在[minValue,maxValue]区间内的元素
            if (v >= minValue && v <= maxValue) {
                //计数加去重
                if (map[v - minValue]++ == 0) {
                    if (v > 0) {
                        //poses数组存所有去重后的正值
                        poses[posSize++] = v;
                    } else if (v < 0) {
                        //negs数组存所有去重后的负值
                        negs[negSize++] = v;
                    }
                }
            }
        }
        //正负数两数组排序
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        //负数数组从后往前遍历
        for (int i = negSize - 1; i >= 0; i--) {
            //nv为当前负数值
            int nv = negs[i];
            //minp = -nv/2，相当于三元组中另外两元素的平均值，即为另两个元素中较小值的上界，较大值的下界
            int minp = (-nv) >>> 1;
            //定位到正数数组中值刚好小于平均值的元素（这个地方应该还可以优化为使用二分查找）
            while (basej < posSize && poses[basej] < minp) {
                basej++;
            }
            //正数数组从大于等于平均值的元素开始遍历
            for (int j = basej; j < posSize; j++) {
                //pv 为当前正数值
                int pv = poses[j];
                //cv 为要寻找的另一个值
                int cv = 0 - nv - pv;
                //目标值 cv 应该在 [nv,pv] 当中
                //如果不限制cv<=pv，当nv为奇数时，有可能会重复输出
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        //两个相同的负数和一个正数的情况
                        if (map[nv - minValue] > 1) {
                            res.add(Arrays.asList(nv, nv, pv));
                        }
                    } else if (cv == pv) {
                        //两个相同的正数和一个负数的情况
                        if (map[pv - minValue] > 1) {
                            res.add(Arrays.asList(nv, pv, pv));
                        }

                    } else {
                        //三个不同元素的情况
                        if (map[cv - minValue] > 0) {
                            res.add(Arrays.asList(nv, cv, pv));
                        }
                    }
                    //如果 cv 小于 nv了，表明这种情况会在后面寻找，为避免重复输出，跳出循环
                } else if (cv < nv) {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 推荐题解 https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 去重
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    // 去重
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> list = threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println();
    }
}
