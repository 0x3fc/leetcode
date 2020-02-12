package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // If there is no more than 3 numbers, there is no combination
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // If current number is larger than 0, no three numbers sum up to 0
            if (nums[i] > 0) break;

            // If the number is the same as previous one, skip
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Search from begin and end
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // Skip duplicated numbers
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (sum > 0) r--;
                else l++;
            }
        }

        return res;
    }
}
