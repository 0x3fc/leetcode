package FindFirstAndLastPositionOfElementInSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findBoundaryIndex(nums, target, true);

        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }

        int right = findBoundaryIndex(nums, target, false) - 1;

        return new int[]{left, right};
    }

    private int findBoundaryIndex(int[] nums, int target, boolean left) {
        int low = 0;
        int high = nums.length;
        int mid;

        while (low < high) {
            mid = (low + high) / 2;

            boolean raiseLowCondition = left ? nums[mid] < target : nums[mid] <= target;

            if (raiseLowCondition) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
