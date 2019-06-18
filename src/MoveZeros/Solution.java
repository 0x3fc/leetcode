package MoveZeros;

class Solution {
    public void moveZeroes(int[] nums) {
        int writer = 0;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            nums[writer++] = num;
        }

        while (writer < nums.length) {
            nums[writer++] = 0;
        }
    }
}
