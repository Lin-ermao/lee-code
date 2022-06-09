package code.q1037;

import test.TestAble;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("isBoomerang",
                    int[][].class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0];
        int[] p2 = points[1];
        int[] p3 = points[2];
        if (Arrays.equals(p1, p2)) {
            return false;
        }
        if (Arrays.equals(p1, p3)) {
            return false;
        }
        if (Arrays.equals(p2, p3)) {
            return false;
        }
        if (p1[1] != p2[1]) {
            double slope1 = getSlope(p1, p2);
            if (p2[1] == p3[1]) {
                return true;
            }
            double slope2 = getSlope(p2, p3);
            return slope1 != slope2;
        }
        return p2[1] != p3[1];
    }

    private double getSlope(int[] p1, int[] p2) {
        int devx = p1[0] - p2[0];
        int devy = p1[1] - p2[1];
        return devx / (double) devy;
    }
}
