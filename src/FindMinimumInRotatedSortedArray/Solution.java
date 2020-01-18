package FindMinimumInRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int i = 0;
        int j = nums.length - 1;

        if (nums[i] < nums[j]) {
            return nums[i];
        }

        while (true) {
            int mid = (i + j) >> 1;

            if (nums[mid + 1] < nums[mid]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
    }
}
