package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {
    private static final String TYPE = "normal";
    private static final int QUESTION_NO = 3;
    private static final String CLASS_NAME = String.format("code.%s.q%d.Solution", TYPE, QUESTION_NO);

    private static Executable getExecuteAbleInstance() throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        Class<?> solutionClass = Class.forName(CLASS_NAME);
        Object instance = solutionClass.newInstance();
        TestAble testInstance = (TestAble) instance;
        Method method = testInstance.getTestMethod();
        return new Executable(instance, method, new Object[] {
                "bbtablud"
        });
    }

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {
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
