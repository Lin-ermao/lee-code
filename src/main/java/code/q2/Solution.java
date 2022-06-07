package code.q2;


import test.ListNode;
import test.TestAble;

import java.lang.reflect.Method;

/**
 * 两数之和
 */
public class Solution implements TestAble {
    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("addTwoNumbers", ListNode.class, ListNode.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fn = new ListNode();
        ListNode non = fn;
        while (!(l1 == null && l2 == null)) {
            ListNode nen = new ListNode();
            int tv = non.val;
            if (l1 != null) {
                tv += l1.val;
            }
            if (l2 != null) {
                tv += l2.val;
            }
            non.val = tv % 10;
            nen.val = tv / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (!(l1 == null && l2 == null) || nen.val != 0) {
                non.next = nen;
                non = nen;
            }
        }
        return fn;
    }
}
