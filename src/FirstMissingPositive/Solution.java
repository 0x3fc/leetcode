package FirstMissingPositive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length < 1) {
            return 1;
        }

        int i = 0;

        while (i < nums.length) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                continue;
            }

            i++;
        }

        i = 0;

        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }

        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
