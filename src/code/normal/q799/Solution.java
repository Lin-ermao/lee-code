package code.normal.q799;

import test.TestAble;

import java.lang.reflect.Method;


/**
 * 香槟塔
 *
 * 我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。
 *
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。
 * 当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 *
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，
 * 第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。
 * 在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 *
 */
public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("champagneTower",
                    int.class, int.class, int.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] A = new double[102][102];
        A[0][0] = poured;
        for (int r = 0; r <= query_row; ++r) {
            for (int c = 0; c <= r; ++c) {
                double q = (A[r][c] - 1.0) / 2.0;
                if (q > 0) {
                    A[r+1][c] += q;
                    A[r+1][c+1] += q;
                }
            }
        }
        return Math.min(1, A[query_row][query_glass]);
    }
}
