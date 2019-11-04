package SearchInRotatedSortedArray;

class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            boolean midAtPivotLeft = nums[0] <= nums[mid];
            boolean targetAtPivotLeft = nums[0] <= target;
            boolean isSameSide = targetAtPivotLeft == midAtPivotLeft;
            
            int midValue = isSameSide
                ? nums[mid]
                : targetAtPivotLeft
                    ? Integer.MAX_VALUE
                    : Integer.MIN_VALUE;

            if (midValue < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        
        return -1;
    }
}
