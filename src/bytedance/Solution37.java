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
     * 官方题解：https://leetcode-cn.com/problems/utf-8-validation/solution/utf-8-bian-ma-yan-zheng-by-leetcode/
     * 不建议看官方题解，下面解法更清晰
     */
    public static boolean validUtf8(int[] data) {
        int n = 0;
        for (int i = 0; i < data.length; i++) {
            if (n > 0) {
                // 如果前两位不以10开头（只考虑8位，因为一个合法的 UTF-8 字符的长度为 1-4 字节）
                if (data[i] >> 6 != 2) {
                    return false;
                }
                n--;
                // data[i]是1字节的字符
            } else if (data[i] >> 7 == 0) {
                n = 0;
                // data[i]是2字节的字符,0b表示二进制
            } else if (data[i] >> 5 == 0b110) {
                // data[i + 1]前两位为10
                n = 1;
                // data[i]是3字节的字符
            } else if (data[i] >> 4 == 0b1110) {
                // data[i + 1]、data[i + 2]前两位为10
                n = 2;
                // data[i]是4字节的字符
            } else if (data[i] >> 3 == 0b11110) {
                // data[i + 1]、data[i + 2]、data[i + 3]前两位为10
                n = 3;
            } else {
                // 一个合法的 UTF-8 字符的长度为 1-4 字节
                return false;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        System.out.println(validUtf8(new int[]{197, 130, 1}));
        System.out.println(validUtf8(new int[]{235, 140, 4}));
    }
}
