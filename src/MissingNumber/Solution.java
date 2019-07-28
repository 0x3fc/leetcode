package MissingNumber;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }

    public int missingNumber2(int[] nums) {
        int res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i] ^ i;
        }

        return res;
    }
}
