package bytedance;

/**
 * **容易**
 * <p>
 * x 的平方根 https://leetcode-cn.com/explore/interview/card/bytedance/247/bonus/1045/
 *
 * @author CaoJing
 * @date 2019/11/12 10:38
 */
public class Solution36 {

    /**
     * 牛顿迭代法 https://blog.csdn.net/junbujianwpl/article/details/78024852
     */
    public static int mySqrt2(long x) {
        double y = 1.0;
        do {
            y = 0.5 * y + 0.5 * x / y;
        } while (Math.abs(y * y - x) >= 1);

        return (int) y;
    }

    /**
     * 二分法：参考题解：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(4));
    }
}
