package code.q563;

import test.TestAble;
import test.TreeNode;

import java.lang.reflect.Method;

public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("findTilt",
                    TreeNode.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    static ValueContainer EMPTY = new ValueContainer(0, 0);

    static class ValueContainer{
        int tilt;
        int sum;

        public ValueContainer(int tilt, int sum) {
            this.tilt = tilt;
            this.sum = sum;
        }
    }

    public int findTilt(TreeNode node) {
        return findTiltAndSum(node).tilt;
    }

    public ValueContainer findTiltAndSum(TreeNode node) {
        if (node == null) {
            return EMPTY;
        }
        ValueContainer leftSum;
        ValueContainer rightSum;
        if (node.left == null) {
            leftSum = EMPTY;
        } else {
            leftSum = findTiltAndSum(node.left);
        }
        if (node.right == null) {
            rightSum = EMPTY;
        } else {
            rightSum = findTiltAndSum(node.right);
        }
        int tilt = Math.abs(leftSum.sum - rightSum.sum) + leftSum.tilt + rightSum.tilt;
        int sum = leftSum.sum + rightSum.sum + node.val;
        return new ValueContainer(tilt, sum);
    }
}
