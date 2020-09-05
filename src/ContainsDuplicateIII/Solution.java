package ContainsDuplicateIII;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        Map<Long, Long> b = new HashMap<>();
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getBucket(nums[i], w);
            if (b.containsKey(id) || (b.containsKey(id - 1) && Math.abs(nums[i] - b.get(id - 1)) <= t)
                    || (b.containsKey(id + 1) && Math.abs(nums[i] - b.get(id + 1)) <= t))
                return true;
            if (i - k >= 0)
                b.remove(getBucket(nums[i - k], w));
            b.put(id, (long) nums[i]);
        }
        return false;
    }

    private long getBucket(long n, long w) {
        return n < 0 ? (n + 1) / w - 1 : n / w;
    }
}
