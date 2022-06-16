package cn.zml.leetcode.editor.cn;

import java.util.Arrays;

public class FindKThSmallestPairDistance {
    public static void main(String[] args) {
        Solution solution = new FindKThSmallestPairDistance().new Solution();
        final int result = solution.smallestDistancePair(new int[]{1,6,1}, 3);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int length = nums.length;
            int left = 0;
            int right = nums[length - 1] - nums[0];
            int mid;
            // 范围只有一个值时，也需要进行验证，不排除个数相等，但是数据可以更小的情况
            while (right >= left) {
                mid = (right + left) / 2;
                int cnt = 0;
                // 统计数对距离小于mid的数对个数
                for (int i = 0; i < length; i++) {
                    // 统计(x, i) x < i 中距离小于mid的个数，则x需满足num[x]的值大于num[j] - mid
                   int j = binarySearch(nums, i, nums[i] - mid);
                    cnt += i - j ;
                }
                if (cnt >= k) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private int binarySearch(int[] nums, int end, int target) {
            int left = 0;
            int right = end;
            int mid;
            while (right > left) {
                mid = (right + left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
