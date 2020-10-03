package KDiffPairsInAnArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0, j = 0; i < nums.length - 1 && j < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (j <= i)
                j = i + 1;
            while (j < nums.length && nums[j] < nums[i] + k)
                j++;
            if (j < nums.length && nums[i] + k == nums[j])
                res++;
        }

        return res;
    }

    // Using Map

    public int findPairsUsingMap(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        if (k == 0)
            return countSelfPairs(counts);

        int res = 0;
        for (int num : counts.keySet()) {
            if (counts.containsKey(num + k))
                res++;
        }

        return res;
    }

    private int countSelfPairs(Map<Integer, Integer> counts) {
        int res = 0;
        for (int count : counts.values()) {
            if (count >= 2)
                res++;
        }
        return res;
    }
}
