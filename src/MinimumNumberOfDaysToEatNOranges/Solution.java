package MinimumNumberOfDaysToEatNOranges;

import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> opt = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1)
            return n;
        if (!opt.containsKey(n)) {
            int o1 = n % 2 + minDays(n / 2);
            int o2 = n % 3 + minDays(n / 3);
            opt.put(n, Math.min(o1, o2) + 1);
        }
        return opt.get(n);
    }
}
