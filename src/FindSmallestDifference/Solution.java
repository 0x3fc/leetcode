package FindSmallestDifference;

import java.util.*;

/**
 * Given two arrays of integers, compute the pair of values (one value in each
 * array) with the smallest (non-negative) difference. Return the difference.
 */

class Solution {
    public int findSmallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        while (i < a.length && j < b.length) {
            min = Math.min(min, Math.abs(a[i] - b[j]));

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testc ase 1

        int[] a1 = new int[] { 1, 3, 15, 11, 2 };
        int[] b1 = new int[] { 23, 127, 235, 19, 8 };

        int actual1 = solution.findSmallestDifference(a1, b1);
        int expect1 = 3;

        assert (actual1 == expect1);

        // Test case 2

        int[] a2 = new int[] { 10, 5, 40 };
        int[] b2 = new int[] { 50, 90, 80 };

        int actual2 = solution.findSmallestDifference(a2, b2);
        int expect2 = 10;

        assert (actual2 == expect2);
    }
}
