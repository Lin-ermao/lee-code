package code.q875;

import test.TestAble;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("minEatingSpeed",
                    int[].class, int.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
// 5868
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int ck = piles[piles.length - 1];
        int cost;
        // 二分法进行查找
        int begin = 0;
        int end = ck;
        while (end > begin) {
            int lk = (end + begin) / 2;
            cost = getCurrentCost(piles, lk);
            if (cost <= h) {
                end = lk;
            } else {
                begin = lk;
                // 当前后两个数，无法进行二分时，则直接取最大值
                if (end - begin < 2) {
                    return end;
                }
            }
        }
        return end;
    }

    private int getCurrentCost(int[] piles, int k) {
        int sum = 0;
        for (int pile : piles) {
            sum += Math.ceil(pile / (double) k);
        }
        return sum;
    }
}
