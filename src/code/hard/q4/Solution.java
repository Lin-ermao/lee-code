package code.hard.q4;


import test.TestAble;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        Arr arr1 = new Arr(nums1);
        Arr arr2 = new Arr(nums2);
        int totalLength = nums1.length + nums2.length;
        boolean isEven = totalLength % 2 == 0;
        if (isEven) {
            int endIndex = (totalLength / 2) - 1;
            int nowIndex = 0;
            while (nowIndex < endIndex) {
                // 如果有一个数组为空，则取另外一个数组的中位数即可
                if (arr1.isEmpty() || arr2.isEmpty()) {
                    int offset = endIndex - nowIndex;
                    return findMedianWithEmptyArray(arr1, arr2, offset , offset + 1);
                }


            }
        }
        return 0;
    }

    /**
     * 计算两个数组中有一个数组为空的场景，直接位移不为空的数组，取到达预定索引值得值即可
     * @param arr1 数组1
     * @param arr2 数组2
     * @param offset1 预定索引1
     * @param offset2 预定索引2，如果总的元素数为奇数个，则offset1 = offset2, 否则值差一
     * @return 中位数
     */
    private double findMedianWithEmptyArray(Arr arr1, Arr arr2, int offset1, int offset2) {
        Arr leftArr = null;
        if (arr1.isEmpty()) {
            leftArr = arr2;
        }
        if (arr2.isEmpty()) {
            leftArr = arr1;
        }
        if (leftArr == null || leftArr.isEmpty()) {
            throw new RuntimeException("输入参数错误");
        }
        int v1 = leftArr.getValue(leftArr.offset + offset1);
        int v2 = leftArr.getValue(leftArr.offset + offset2);
        return (v1 + v2) / 2.0;
    }

    private static class Arr {
        int[] data;
        int offset;
        int length;

        public Arr(int[] data) {
            this.data = data;
            offset = 0;
            length = data.length;
        }

        public Arr(int[] data, int offset, int length) {
            this.data = data;
            this.offset = offset;
            this.length = length;
        }

        boolean isEmpty() {
            if (data == null) {
                return true;
            }
            return length > 0;
        }

        int getValue(int index) {
            return data[index];
        }
    }
}
