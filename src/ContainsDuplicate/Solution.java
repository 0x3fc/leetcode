package ContainsDuplicate;

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for (int num : nums) {
            if (s.contains(num)) {
                return true;
            }

            s.add(num);
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
