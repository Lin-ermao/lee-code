package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class DataConverter {
    private static final String INPUT_PATH = "src/inputArr.json";

    public static String readInputStr() {
        try {
            return IOUtils.toString(new FileInputStream(INPUT_PATH));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static String convert2Number(ListNode node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static int[][] convert2Gird(String jsonStr) {
        JSONArray array = JSON.parseArray(jsonStr);
        int[][] result = new int[array.size()][];
        int j = 0;
        for (Object arrObj : array) {
            JSONArray arr = (JSONArray) arrObj;
            int[] item = new int[arr.size()];
            int i = 0;
            for (Object o : arr) {
                item[i++] = (int) o;
            }
            result[j++] = item;
        }
        return result;
    }

    public static <T> T[] revertArr(T[] arr) {
        Stack<T> stack = new Stack<>();
        for (T t : arr) {
            stack.push(t);
        }
        int i = 0;
        while (!stack.empty()) {
            arr[i] = stack.pop();
            i ++;
        }
        return arr;
    }

    public static void revertArr(char[] arr) {
        Stack<Character> stack = new Stack<>();
        for (char t : arr) {
            stack.push(t);
        }
        int i = 0;
        while (!stack.empty()) {
            arr[i] = stack.pop();
            i ++;
        }
    }

    public static ListNode convert2ListNode(String inputNumber, boolean revert) {
        ListNode fn = new ListNode();
        ListNode non = fn;
        char[] chars = inputNumber.toCharArray();
        if (revert){
            revertArr(chars);
        }
        int i = 0;
        do {
            non.val = chars[i] - '0';
            i ++;
            if (i < chars.length) {
                non.next = new ListNode();
                non = non.next;
            }
        } while (i < chars.length);

        return fn;
    }

    public static int[] convert2Arr(String jsonStr) {
        JSONArray array = JSON.parseArray(jsonStr);
        int[] result = new int[array.size()];
        int i = 0;
        for (Object o : array) {
            result[i++] = (int) o;
        }
        return result;
    }

    public static TreeNode convert2TreeNode(String jsonStr) {
        Stack<Integer> nodeValue = new Stack<>();
        List<Integer> list = JSON.parseArray(jsonStr).toJavaList(Integer.class);
        Collections.reverse(list);
        nodeValue.addAll(list);
        Queue<TreeNode> nodeQueue = new LinkedBlockingQueue<>();
        TreeNode rootNode = new TreeNode(nodeValue.pop());
        nodeQueue.add(rootNode);
        generateTreeNode(nodeValue, nodeQueue);
        return rootNode;
    }

    private static void generateTreeNode(Stack<Integer> nodeValue,
                                             Queue<TreeNode> nodeQueue) {
        TreeNode nowNode = nodeQueue.poll();
        while (nowNode != null) {
            TreeNode leftNode;
            TreeNode rightNode;
            if (nodeValue.empty()) {
                break;
            }
            Integer valueLeft = nodeValue.pop();
            if (valueLeft != null) {
                leftNode  = new TreeNode(valueLeft);
                nodeQueue.add(leftNode);
            } else {
                leftNode = null;
            }
            if (nodeValue.empty()) {
                break;
            }
            Integer valueRight = nodeValue.pop();
            if (valueRight != null) {
                rightNode = new TreeNode(valueRight);
                nodeQueue.add(rightNode);
            } else {
                rightNode = null;
            }
            nowNode.left = leftNode;
            nowNode.right = rightNode;
            nowNode = nodeQueue.poll();
        }
    }
}
