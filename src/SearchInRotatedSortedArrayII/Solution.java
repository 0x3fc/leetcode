package SearchInRotatedSortedArrayII;

class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        int mid;

        while (i <= j) {
            while (i < j && nums[i] == nums[j]) {
                j--;
            }

            mid = (i + j) / 2;

            if (nums[mid] == target) {
                return true;
            }

            boolean isPivotInLeft = nums[0] > nums[mid];
            boolean isTargetInLeft = target >= nums[0];

            double modifiedMid = isPivotInLeft == isTargetInLeft
                    ? isTargetInLeft ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY
                    : nums[mid];

            if (modifiedMid < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }
}
