package MinimumOperationsToReduceXToZero;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for (int n : nums)
            target += n;
        if (target == 0)
            return nums.length;
        int partialSum = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, -1); // Partial sum 0 at -1
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            partialSum += nums[i];
            int composite = partialSum - target;
            if (m.containsKey(composite))
                max = Math.max(max, i - m.get(composite));
            m.put(partialSum, i);
        }
        return max == -1 ? -1 : nums.length - max;
    }
}
