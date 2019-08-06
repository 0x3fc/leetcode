package JumpGameII;

class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);

            if (curFarthest >= nums.length - 1) {
                return count + 1;
            }

            if (i == curEnd) {
                count++;
                curEnd = curFarthest;
            }
        }

        return count;
    }

    public int jump2(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int i = 0;
        int count = 0;
        int curEnd = 0;
        int curFarthest = 0;

        while (i < nums.length) {
            count++;
            while (i <= curEnd) {
                curFarthest = Math.max(curFarthest, i + nums[i]);

                if (curFarthest >= nums.length - 1) {
                    return count;
                }

                i++;
            }
            curEnd = curFarthest;
        }

        return count;
    }
}
