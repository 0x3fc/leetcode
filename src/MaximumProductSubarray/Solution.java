package MaximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        // Keep a maximum and a minimum (usually negative).
        // Keep the minimum for encountering a negative since
        // negative times negative gives a positive (maximum candidate)
        int max = result;
        int min = result;

        for (int i = 1; i < nums.length; i++) {
            // If we encounter a negative, swap max and min so that
            // our min (usually negative) can become positive (max candidate)
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }

            // Use the current number as the product OR start a new subarray
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }

        return result;
    }
}
