package bytedance;

/**
 * 字符串相乘 https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1015/  TODO
 *
 * @author CaoJing
 * @date 2019/11/10 20:08
 */
public class Solution4 {

    /**
     * 用时最快的代码 https://leetcode-cn.com/submissions/detail/36114308/
     */
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length(), l2 = num2.length(), l = l1 + l2;
        char[] ans = new char[l];
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        for (int i = l1 - 1; i >= 0; --i) {
            int c = c1[i] - '0';
            for (int j = l2 - 1; j >= 0; --j) {
                ans[i + j + 1] += c * (c2[j] - '0');
            }
        }
        for (int i = l - 1; i > 0; --i) {
            if (ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; ; ++i) if (ans[i] != 0) break;
        for (; i < ans.length; ++i) sb.append((char) (ans[i] + '0'));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }
}
