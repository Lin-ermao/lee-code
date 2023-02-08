package cn.zml.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class MaximizeScoreAfterNOperations {
    public static void main(String[] args) {
        Solution solution = new MaximizeScoreAfterNOperations().new Solution();
        int[] nums = new int[]{39759,619273,859218,228161,944571,597983,483239,179849,868130,909935,912143,817908,738222,653224};
        System.out.println(solution.maxScore(nums));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final Map<Integer, Map<Integer, Integer>> gcdRecord = new HashMap<>();
    private static final Map<Arr, Integer> scoreRecord = new HashMap<>();

    private static class Arr{
        private final int[] arr;

        private Arr(int[] arr) {
            this.arr = arr;
        }


        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }

        @Override
        public boolean equals(Object obj) {
            return Arrays.equals(arr, ((Arr)obj).arr);
        }
    }

    public int maxScore(int[] nums) {
        final int[] zip = zip(nums);
        Arr key = new Arr(zip);
        final Integer score = scoreRecord.get(key);
        if (score != null) {
            return score;
        }
        if (zip.length == 2) {
            return gcd(zip[0], zip[1]);
        }
        int maxv = 0;
        int v;
        for (int i = 0; i < zip.length; i++) {
            int reci = zip[i];
            zip[i] = 0;
            for (int j = i + 1; j < zip.length; j++) {
                int recj = zip[j];
                zip[j] = 0;
                v = maxScore(zip) + gcd(reci, recj) * (zip.length / 2);
                if (v > maxv) {
                    maxv = v;
                }
                zip[j] = recj;
            }
            zip[i] = reci;
        }
        scoreRecord.put(key, maxv);
        return maxv;
    }

    private static int gcd(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a,b);
        final Map<Integer, Integer> minGcd = gcdRecord.computeIfAbsent(max, k -> new HashMap<>());
        final Integer exists = minGcd.get(min);
        if (exists != null) {
            return exists;
        }
        int x = Math.max(a, b);
        int y = Math.min(a, b);
        int r;
        while (x % y != 0) {
            r = x % y;
            x = Math.max(r, y);
            y = Math.min(r, y);
        }
        minGcd.put(min, y);
        return y;
    }

    private int[] zip(int[] nums) {
        final List<Integer> zipList = new ArrayList<>(nums.length);
        for (int num : nums) {
            if (num > 0) {
                zipList.add(num);
            }
        }
        int [] res = new int[zipList.size()];
        int index = 0;
        for (Integer v : zipList) {
            res[index++] = v;
        }
        return res;
    }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
