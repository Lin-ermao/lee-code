package cn.zml.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public static void main(String[] args) {
        Solution solution = new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().new Solution();
        System.out.println(solution.alertNames(new String[]{"leslie","leslie","leslie","clare","clare","clare","clare"},
                new String[]{"13:00","13:20","14:00","18:00","18:51","19:30","19:49"}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        TreeMap<String, TreeSet<String>> record = new TreeMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            final TreeSet<String> timeRecord = record.computeIfAbsent(name, n -> new TreeSet<>());
            timeRecord.add(time);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, TreeSet<String>> entry : record.entrySet()) {
            final String name = entry.getKey();
            final TreeSet<String> timeValues = entry.getValue();
            if (meet(timeValues)) {
                result.add(name);
            }
        }
        return result;
    }

    private boolean meet(TreeSet<String> times) {
        TreeSet<String> record = new TreeSet<>();
        for (String time : times) {
            record.add(time);
            final String first = record.first();
            final String last = record.last();
            if (!inRange(first, last)) {
                record.remove(first);
                continue;
            }
            if (record.size() == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean inRange(String before, String after) {
        final String[] split1 = before.split(":");
        final String[] split2 = after.split(":");
        int beforeHour = Integer.parseInt(split1[0]);
        int afterHour = Integer.parseInt(split2[0]);
        if (beforeHour > afterHour) {
            return false;
        }
        int beforeMin = Integer.parseInt(split1[1]);
        int afterMin = Integer.parseInt(split2[1]);
        return (afterHour * 60 + afterMin) - (beforeHour * 60 + beforeMin) <= 60;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
