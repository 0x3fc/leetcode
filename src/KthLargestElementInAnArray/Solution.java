package KthLargestElementInAnArray;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        int i = partition(nums, start, end);

        if (i == k - 1) {
            return nums[i];
        }

        if (i < k - 1) {
            return quickSelect(nums, k, i + 1, end);
        }

        return quickSelect(nums, k, 0, i - 1);
    }

    private int partition(int[] nums, int start, int end) {
        int pivotIndex = (start + end) / 2;
        int pivot = nums[pivotIndex];

        swap(nums, end, pivotIndex);

        int i = start;

        for (int j = start; j < end; j++) {
            if (nums[j] > pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, end);

        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
