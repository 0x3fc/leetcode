package ContiguousArray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        // Set initial count as 0 at index -1
        counts.put(0, -1);

        int maxLength = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;

            if (counts.containsKey(count)) {
                int length = i - counts.get(count);
                maxLength = Math.max(maxLength, length);
            } else {
                counts.put(count, i);
            }
        }

        return maxLength;
    }
}
