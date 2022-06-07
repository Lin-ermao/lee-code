package code.q4;


import test.TestAble;

import java.lang.reflect.Method;

/**
 *
 * 寻找两个正序数组的中位数
 */
public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("findMedianSortedArrays", int[].class, int[].class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int totalNum = l1 + l2;
        boolean isOdds = totalNum % 2 == 1;
        int endSize = totalNum / 2;
        int index = 0;
        IndexRecord indexRecord = new IndexRecord(l1, l2);
        while(index < endSize - 1) {
            index ++;
            nextMinValue(nums1, nums2,indexRecord);
        }
        // 奇数
        if (isOdds) {
            if (l1 + l2 == 1) {
                return nextMinValue(nums1, nums2,indexRecord);
            }
            nextMinValue(nums1, nums2,indexRecord);
            return nextMinValue(nums1, nums2,indexRecord);
        } else {
            return (nextMinValue(nums1, nums2,indexRecord) + nextMinValue(nums1, nums2,indexRecord)) / 2.0;
        }
    }

    private int nextMinValue(int[] nums1, int[] nums2, IndexRecord record) {
        // 有一个数组遍历结束
        if (record.i > record.l1 - 1) {
            record.j ++;
            return nums2[record.j - 1];
        }
        if (record.j > record.l2 - 1) {
            record.i ++;
            return nums1[record.i - 1];
        }
        if (nums1[record.i] > nums2[record.j]) {
            record.j ++;
            return nums2[record.j - 1];
        } else {
            record.i ++;
            return nums1[record.i - 1];
        }
    }

    static class IndexRecord {
        final int l1;
        final int l2;
        int i;
        int j;

        public IndexRecord(int l1, int l2) {
            this.l1 = l1;
            this.l2 = l2;
            i = 0;
            j = 0;
        }
    }

}
