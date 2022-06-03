package code.normal.q3;

import test.TestAble;

import java.lang.reflect.Method;

public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("lengthOfLongestSubstring",
                    String.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException();
        }
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        byte[] record = new byte[128 - 32];
        byte ni = 1;
        int result = 0;
        for (char aChar : chars) {
            byte index = (byte) (aChar - 32);
            int poi = record[index];
            if (poi == 0) {
                record[index] = ni;
                ni ++;
                continue;
            }
            // 出现重复字符，终端当前统计
            result = Math.max(result, count(record));
            // 将当前字符加入的记录中
            record[index] = ni;
            // 记录后移，把和最后一位重复的字符移除
            move(record, poi);
            // index减去移动位数
            ni = (byte)(ni - poi + 1);
        }
        return Math.max(result, count(record));
    }

    private int count(byte[] record) {
        int count = 0;
        for (byte b : record) {
            if (b != 0) {
                count ++;
            }
        }
        return count;
    }

    private void move(byte[] record, int length) {
        for (int i = 0; i < record.length; i++) {
            record[i] = (byte) Math.max(0, record[i] - length);
        }
    }
}
