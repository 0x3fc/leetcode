package FirstMissingPositive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length
            // Destiny is not the correct number
                    && nums[nums[i] - 1] != nums[i]) {
                int index = nums[i] - 1;
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }

        return nums.length + 1;
    }
}
