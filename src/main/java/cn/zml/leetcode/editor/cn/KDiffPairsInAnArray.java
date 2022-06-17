package cn.zml.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KDiffPairsInAnArray {
    public static void main(String[] args) {
        Solution solution = new KDiffPairsInAnArray().new Solution();
        final int pairs = solution.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3}, 3);
        System.out.println(pairs);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int count = 0;
        int currentValue;
        Set<Integer> record = new HashSet<>();
        for (int i = 0; i < length; i++) {
            currentValue = nums[i];
            int target = currentValue - k;
            int index = binarySearch(nums, i, target);
            if (index != -1) {
                if (record.contains(currentValue)) {
                    continue;
                } else {
                    record.add(currentValue);
                }
                count ++;
            }
        }
        return count;
    }

    /**
     * 在nums数组中寻找index小于end且值等于v的索引
     * @param nums 数组数据
     * @param end 结束索引
     * @param target 目标值
     * @return 如果查找到则返回目标数据的索引，否则返回-1
     */
    private int binarySearch(int[] nums, int end, int target) {
        int left = 0;
        // 范围为[0, end)
        int right = end;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
