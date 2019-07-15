package RotateArray;

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            // Switch nums[i] and nums[j]
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];

            i++;
            j--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;

        if (len == 0) {
            return;
        }

        k = k % len;

        if (k == 0) {
            return;
        }

        int count = 0;

        for (int i = 0; count < len; i++) {
            int curr = i;
            int tmp = nums[curr];

            do {
                int next = (curr + k) % len;

                // Switch tmp and nums[next]
                tmp = tmp ^ nums[next];
                nums[next] = tmp ^ nums[next];
                tmp = tmp ^ nums[next];

                curr = next;
                count++;
            } while (curr != i);
        }
    }
}
