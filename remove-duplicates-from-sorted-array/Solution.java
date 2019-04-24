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

    public static void main(String[] args) {
        // int[] nums = { 1, 1, 2 };
        // int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        // int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        Solution solution = new Solution();
        int len = solution.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
