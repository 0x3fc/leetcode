package SubarrayProductLessThanK;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int count = 0, product = 1;

        for (int start = 0, end = 0; end < nums.length; end++) {
            product *= nums[end];
            while (product >= k)
                product /= nums[start++];
            count += end - start + 1;
        }

        return count;
    }
}
