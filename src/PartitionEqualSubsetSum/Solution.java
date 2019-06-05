package PartitionEqualSubsetSum;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Odd sum cannot be partitioned
        if ((sum & 1) == 1) {
            return false;
        }

        // If we can sum up half of the sum, we found the partition
        int target = sum / 2;

        boolean[] opt = new boolean[target + 1];
        opt[0] = true;

        for (int num : nums) {
            // Going from right to left to avoid using a number multiple times
            for (int i = target; i > 0; i--) {
                if (i < num) {
                    continue;
                }

                opt[i] = opt[i] || opt[i - num];
            }
        }

        return opt[target];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        return helper(nums, nums.length - 1, sum / 2);
    }

    private boolean helper(int[] nums, int i, int sum) {
        if (sum == 0) {
            return true;
        }

        if (i < 0 || sum < 0 || sum < nums[i]) {
            return false;
        }

        return helper(nums, i - 1, sum - nums[i]) || helper(nums, i - 1, sum);
    }
}
