package SlidingWindowMaximum;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> indices = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indices.isEmpty() && indices.peek() < i - k + 1) {
                indices.poll();
            }
            while (!indices.isEmpty() && nums[indices.peekLast()] < nums[i]) {
                indices.pollLast();
            }
            indices.offer(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[indices.peek()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindowTwoPasses(int[] nums, int k) {
        int n = nums.length;
        int[] leftMaxs = new int[n];
        int rightMax = 0;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            leftMaxs[i] = i % k == 0 ? nums[i] : Math.max(leftMaxs[i - 1], nums[i]);
        }

        for (int j = n - 1; j >= 0; j--) {
            rightMax = (j + 1) % k == 0 || j == n - 1 ? nums[j] : Math.max(rightMax, nums[j]);
            if (j <= n - k) {
                res[j] = Math.max(leftMaxs[j + k - 1], rightMax);
            }
        }

        return res;
    }
}
