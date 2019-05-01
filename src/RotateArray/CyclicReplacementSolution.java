package RotateArray;

class CyclicReplacementSolution {
    public void rotate(int[] nums, int k) {
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
