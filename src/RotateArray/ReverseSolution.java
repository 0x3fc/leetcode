package RotateArray;

public class ReverseSolution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            // Switch nums[i] and nums[j]
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];

            i++;
            j--;
        }
    }
}
