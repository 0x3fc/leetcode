package BinarySearch;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int pivot = (r - l) / 2 + l;
            int mid = nums[pivot];

            if (mid == target)
                return pivot;

            if (mid < target)
                l = pivot + 1;
            else
                r = pivot - 1;
        }

        return -1;
    }
}
