package FindPeakElement;

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1)
            return 0;

        int i = 0, j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) >> 1;
            int moveDirection = shouldMoveTowards(nums, mid);

            if (moveDirection == 0)
                return mid;

            if (moveDirection < 0)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return 0;
    }

    private int shouldMoveTowards(int[] nums, int idx) {
        if (idx == 0)
            return nums[0] > nums[1] ? 0 : 1;
        if (idx == nums.length - 1)
            return nums[idx] > nums[idx - 1] ? 0 : -1;

        return nums[idx] > nums[idx + 1] && nums[idx] > nums[idx - 1] ? 0 : nums[idx + 1] - nums[idx];
    }
}
