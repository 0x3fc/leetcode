package HouseRobber;

class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int n1 = 0;
        int n2 = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = Math.max(n2, n1 + nums[i]);
            n1 = n2;
            n2 = res;
        }

        return res;
    }
}
