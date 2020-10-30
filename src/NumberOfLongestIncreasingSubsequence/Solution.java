package NumberOfLongestIncreasingSubsequence;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] counts = new int[nums.length];
        int[] lengths = new int[nums.length];

        int max = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            counts[i] = 1;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    } else if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }

            if (lengths[i] > max) {
                res = counts[i];
                max = lengths[i];
            } else if (max == lengths[i]) {
                res += counts[i];
            }
        }

        return res;
    }
}
