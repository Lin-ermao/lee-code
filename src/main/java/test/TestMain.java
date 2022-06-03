package test;

import java.lang.reflect.Method;

public class TestMain {
    private static final String TYPE = "hard";
    private static final int QUESTION_NO = 4;
    private static final String CLASS_NAME = String.format("code.%s.q%d.Solution", TYPE, QUESTION_NO);

    private static Executable getExecuteAbleInstance() throws Exception {
        Class<?> solutionClass = Class.forName(CLASS_NAME);
        Object instance = solutionClass.getDeclaredConstructor().newInstance();
        TestAble testInstance = (TestAble) instance;
        Method method = testInstance.getTestMethod();
        return new Executable(instance, method, new Object[] {
                new int[] {1}, new int[]{}
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
