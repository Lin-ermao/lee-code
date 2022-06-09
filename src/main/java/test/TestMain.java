package test;

import java.lang.reflect.Method;

public class TestMain {
    private static final int QUESTION_NO = 1037;
    private static final String CLASS_NAME = String.format("code.q%d.Solution", QUESTION_NO);

    private static Executable getExecuteAbleInstance() throws Exception {
        Class<?> solutionClass = Class.forName(CLASS_NAME);
        Object instance = solutionClass.getDeclaredConstructor().newInstance();
        TestAble testInstance = (TestAble) instance;
        Method method = testInstance.getTestMethod();
        int[] piles = DataConverter.convert2Arr(DataConverter.readInputStr());
        return new Executable(instance, method, new Object[] {
               new int[][] {{1,0},{2,0},{3, 1}}
        });
    }

    public static void main(String[] args) throws Exception {
        long b = System.currentTimeMillis();
        Executable executable = getExecuteAbleInstance();
        Object result = executable.method.invoke(executable.instance, executable.args);
        long e = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("cost:" + (e - b));
    }

    private static class Executable {
        Object instance;
        Method method;
        Object[] args;

        public Executable(Object instance, Method method, Object[] args) {
            this.instance = instance;
            this.method = method;
            this.args = args;
        }
    }
}
