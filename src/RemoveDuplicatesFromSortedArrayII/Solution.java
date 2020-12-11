package RemoveDuplicatesFromSortedArrayII;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3)
            return nums.length;
        int count = 1;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            count = nums[i] == nums[i - 1] ? count + 1 : 1;
            if (count > 2)
                continue;
            nums[j++] = nums[i];
        }
        return j;
    }
}
