package code.easy.q1656;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class OrderedStream {
    private int ptr = 0;

    private final String[] container;

    public OrderedStream(int n) {
        container = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        container[idKey - 1] = value;
        if (container[ptr] == null) {
            return Collections.emptyList();
        }
        LinkedList<String> result = new LinkedList<>();
        while (ptr <= container.length - 1 && container[ptr] != null ) {
            result.add(container[ptr]);
            ptr ++;
        }
        return result;
    }
}
