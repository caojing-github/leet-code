package bytedance;

/**
 * UTF-8 编码验证 https://leetcode-cn.com/explore/interview/card/bytedance/247/bonus/1037/
 *
 * @author CaoJing
 * @date 2019/11/12 10:42
 */
public class Solution37 {

    /**
     * 用时最快 https://leetcode-cn.com/submissions/detail/36266386/
     */
    public boolean validUtf8(int[] data) {
        if (data.length == 0) return false;
        for (int i = 0; i < data.length; i++) {
            if ((data[i] >>> 7) == 0)
                continue;
            if ((data[i] >>> 5) == 6) {
                i++;
                if (i >= data.length)
                    return false;
                if ((data[i] >>> 6) != 2)
                    return false;
            } else if ((data[i] >>> 4) == 14) {
                for (int j = 0; j < 2; j++) {
                    i++;
                    if (i >= data.length)
                        return false;
                    if ((data[i] >>> 6) != 2)
                        return false;
                }
            } else if ((data[i] >>> 3) == 30) {
                for (int j = 0; j < 3; j++) {
                    i++;
                    if (i >= data.length)
                        return false;
                    if ((data[i] >>> 6) != 2)
                        return false;
                }
            } else
                return false;
        }
        return true;
    }
}
