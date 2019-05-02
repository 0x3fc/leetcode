package SearchInRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        int mid;

        while (i <= j) {
            mid = (i + j) / 2;

            if (nums[mid] == target) {
                return mid;
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

        return -1;
    }
}
