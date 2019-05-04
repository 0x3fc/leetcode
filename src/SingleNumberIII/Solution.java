package SingleNumberIII;

class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;

        for (int num : nums) {
            diff ^= num;
        }

        int lastDiffBit = diff & -diff;

        int res = diff;
        for (int num : nums) {
            if ((num & lastDiffBit) == 0) {
                res ^= num;
            }
        }

        return new int[]{res, res ^ diff};
    }
}
