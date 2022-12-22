package cn.zml.leetcode.editor.cn;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return revertNumber(x) == x;
    }
// 101  1001   112211
    public static int revertNumber(int value) {
        int result = 0;
        int rest = value;
        do {
            result = result * 10 + (rest - (rest / 10) * 10);
            rest /= 10;
        } while (rest > 0);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
