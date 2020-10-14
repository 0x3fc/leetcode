package HouseRobberII;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        // Rob the first house but not the last house
        int r1_1 = nums[0], r1_2 = 0;
        // Rob the second house til the last house
        int r2_1 = 0, r2_2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int r1 = Math.max(r1_1, r1_2 + nums[i]);
            r1_2 = r1_1;
            r1_1 = r1;

            int r2 = Math.max(r2_1, r2_2 + nums[i]);
            r2_2 = r2_1;
            r2_1 = r2;
        }

        return Math.max(r1_2, Math.max(r2_1, r2_2));
    }
}
