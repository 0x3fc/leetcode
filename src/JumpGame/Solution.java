package JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int maxCanReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxCanReach) {
                return false;
            }

            maxCanReach = Math.max(maxCanReach, nums[i] + i);

            if (maxCanReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
