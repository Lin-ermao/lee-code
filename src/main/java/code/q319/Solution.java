package code.q319;

import test.TestAble;

import java.lang.reflect.Method;

/**
 * 灯泡开关
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
 * <p>
 * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，
 * 你每 i 个灯泡就切换一个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * <p>
 * 找出并返回 n轮后有多少个亮着的灯泡
 */
public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("bulbSwitch",
                    int.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public int bulbSwitch(int n) {
        return (int)Math.floor(Math.sqrt(n));
    }
}
