package RemoveDuplicatesFromSortedArray;

class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        if (length <= 1) {
            return length;
        }

        int write = 0;
        int go = 1;

        while (go < length) {
            if (nums[go] != nums[write]) {
                write++;
                nums[write] = nums[go];
            }

            go++;
        }

        return write + 1;
    }
}
