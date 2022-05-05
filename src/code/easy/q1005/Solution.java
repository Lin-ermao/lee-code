package code.easy.q1005;

import test.TestAble;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("largestSumAfterKNegations",
                    int[].class, int.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                break;
            }
            int v = nums[i];
            if (v <= 0) {
                nums[i] = - v;
            } else {
                for (int j = 0; j < k - i; j++) {
                    int index = Math.max(i - 1, 0);
                    if (Math.abs(nums[i]) < Math.abs(nums[index])) {
                        index =  i;
                    }
                    nums[index] = - nums[index];
                }
                break;
            }
        }
        if (nums.length < k) {
            for (int j = 0; j < k - nums.length; j++) {
                int index = nums.length - 1;
                nums[index] = - nums[index];
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
