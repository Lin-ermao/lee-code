package code.q929;

import test.TestAble;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author maoLin Zhao
 * @since 2022-06-04
 */
public class Solution  implements TestAble {

    @Override
    public Method getTestMethod() {
        try {
            return this.getClass().getMethod("numUniqueEmails",
                    String[].class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> resultSet = new HashSet<>();
        for (String email: emails) {
            final String[] segments = email.split("@");
            String name = segments[0].replace(".", "");
            String finalName = name.replaceAll("\\+(\\w+)", "");
            resultSet.add(finalName + "@" + segments[1]);
        }
        return resultSet.size();
    }
}
