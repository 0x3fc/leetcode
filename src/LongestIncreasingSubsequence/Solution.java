package LongestIncreasingSubsequence;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int[] opt = new int[nums.length];
        int max = 1;

        opt[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int localMax = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    localMax = Math.max(localMax, opt[j]);
                }
            }

            opt[i] = localMax + 1;
            max = Math.max(max, opt[i]);
        }

        return max;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int[] res = new int[nums.length];
        int len = 0;
        res[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res[len]) {
                res[++len] = nums[i];
            } else {
                int pos = binarySearch(res, nums[i], len - 1);
                res[pos] = nums[i];
            }
        }

        return len + 1;
    }

    public int binarySearch(int[] nums, int x, int high) {
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (x == nums[mid]) {
                return mid;
            }

            if (x < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
