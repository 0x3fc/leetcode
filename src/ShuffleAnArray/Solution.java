package ShuffleAnArray;

import java.util.*;

class Solution {
    private int[] nums;
    private int[] shuffled;
    private Random rand = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
        this.shuffled = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // Knuth shuffle
        for (int i = shuffled.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            int tmp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = tmp;
        }

        return shuffled;
    }
}
