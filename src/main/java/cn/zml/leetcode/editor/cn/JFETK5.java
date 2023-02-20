package cn.zml.leetcode.editor.cn;

public class JFETK5 {
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String addBinary(String a, String b) {
        final char[] aChars = a.toCharArray();
        final char[] bChars = b.toCharArray();
        char[] max;
        char[] min;
        if (aChars.length > bChars.length) {
            max = aChars;
            min = bChars;
        } else {
            max = bChars;
            min = aChars;
        }
        StringBuilder sb = new StringBuilder();
        int m = 0;
        int i = 0;
        while (i < max.length) {
            int mi;
            int ma = max[max.length - i - 1] - '0';
            if (i >= min.length) {
                mi = 0;
            } else {
                mi = min[min.length - i - 1] - '0';
            }
            int sum = mi + ma + m;
            int now = sum % 2;
            m = sum / 2;
            i++;
            sb.append(now);
        }
        if (m != 0) {
            sb.append(m);
        }
        sb.reverse();
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
