package SortColors;

class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int twos = nums.length - 1;

        int i = 0;

        while (zeros < twos && i <= twos) {
            for (; zeros < twos && nums[zeros] == 0; zeros++) ;
            for (; zeros < twos && nums[twos] == 2; twos--) ;

            if (i < zeros) {
                i = zeros;
            }

            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[zeros];
                nums[zeros] = tmp;
                zeros++;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[twos];
                nums[twos] = tmp;
                twos--;
            } else {
                i++;
            }
        }
    }
}
