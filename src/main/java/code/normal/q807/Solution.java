package code.normal.q807;

import test.TestAble;

import java.lang.reflect.Method;

public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("maxIncreaseKeepingSkyline",
                    int[][].class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rowNum = grid.length;
        int lineNum = grid[0].length;
        int[] lineMax = new int[lineNum];
        int[] rowMax = new int[rowNum];
        for (int i = 0; i < rowNum; i++) {
            int max = 0;
            for (int j : grid[i]) {
                max = Math.max(max, j);
            }
            rowMax[i] = max;
        }
        for (int i = 0; i < lineNum; i++) {
            int max = 0;
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            lineMax[i] = max;
        }
        int add = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < lineNum; j++) {
                int allowMax = Math.min(lineMax[j], rowMax[i]);
                add += allowMax - grid[i][j];
            }
        }
        return add;
    }
}
