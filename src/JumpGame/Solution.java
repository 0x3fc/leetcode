package JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        
        int max = nums[0];
        int length = nums.length;
        for (int i = 1; i < length && i <= max && max < length - 1; i++) {
            max = Math.max(max, i + nums[i]);
        }
        
        return max >= length - 1;
    }
}
