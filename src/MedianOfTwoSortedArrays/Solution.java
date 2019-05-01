package MedianOfTwoSortedArrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // Check for nums1 emptyness
        if (n == 0) {
            int mid = m / 2;

            return (m & 1) == 0 ? (double) (nums2[mid - 1] + nums2[mid]) / 2 : nums2[mid];
        }

        // Check for nums2 emptyness
        if (m == 0) {
            int mid = n / 2;

            return (n & 1) == 0 ? (double) (nums1[mid - 1] + nums1[mid]) / 2 : nums1[mid];
        }

        // Make sure nums1 is shorter
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Numbers per side in finding median
        int perSide = (n + m + 1) / 2;

        // Binary search boundaries
        int start = 0;
        int end = n;

        // Cursor on nums1 and nums2
        int i, j;

        do {
            // Do binary search on nums1
            i = (start + end) / 2;

            // Calculate j for #left == #right condition
            j = perSide - i;

            // Get nums1_{i-1} and nums1_i
            int aLeft = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int aRight = i == n ? Integer.MAX_VALUE : nums1[i];

            // Get nums2_{j-1} and nums2_j
            int bLeft = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int bRight = j == m ? Integer.MAX_VALUE : nums2[j];

            // Move cursor to left
            if (aLeft > bRight) {
                end = i - 1;
                continue;
            }

            // Move cursor to right
            if (bLeft > aRight) {
                start = i + 1;
                continue;
            }

            // Found the median
            return ((n + m) & 1) == 0 ? (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2
                    : Math.max(aLeft, bLeft);
        } while (true);
    }
}
