package cn.zml.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestPokerHand {
    public static void main(String[] args) {
        Solution solution = new BestPokerHand().new Solution();
        System.out.println(
                solution.bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        Map<Character, List<Integer>> sameSuit = new HashMap<>();
        Map<Integer, List<Character>> sameRank = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            int rank = ranks[i];
            char suit = suits[i];
            final List<Character> sl = sameRank.computeIfAbsent(rank, k -> new ArrayList<>(5));
            sl.add(suit);
            final List<Integer> rl = sameSuit.computeIfAbsent(suit, k -> new ArrayList<>(5));
            rl.add(rank);
        }
        if (sameSuit.size() == 1) {
            return "Flush";
        }
        int max = 0;
        for (Map.Entry<Integer, List<Character>> entry : sameRank.entrySet()) {
            max = Math.max(entry.getValue().size(), max);
        }
        switch (max) {
            case 5:
            case 4:
            case 3: return "Three of a Kind";
            case 2: return "Pair";
            default: return "High Card";
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
