package code.normal.q397;

import test.TestAble;

import java.lang.reflect.Method;

/**
 * 整数替换
 *
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 */
public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("integerReplacement",
                    int.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public int integerReplacement(int l) {
        int times = 0;
        long n = l;
        while (n != 1) {
            if (n % 2 == 1) {
                String i1 = Long.toBinaryString(n + 1);
                String i2 = Long.toBinaryString(n - 1);
                int z1 = count1(i1);
                int z2 = count1(i2);
                if (z1 > z2) {
                    n --;
                } else if (z1 < z2){
                    n ++;
                } else {
                    if (i1.length() > i2.length()) {
                        n --;
                    } else {
                        n ++;
                    }
                }
            } else {
                n /= 2;
            }
            times ++;
        }
        return times;
    }

    private int count1(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                count ++;
            }
        }
        return count;
    }
}
