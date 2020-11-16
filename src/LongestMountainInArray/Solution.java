package LongestMountainInArray;

class Solution {
    public int longestMountain(int[] A) {
        int l = 0, r = 0, max = 0;

        while (l < A.length - 2) {
            while (l < A.length - 1 && A[l] >= A[l + 1])
                l++;
            r = l + 1;
            while (r < A.length - 1 && A[r] < A[r + 1])
                r++;
            while (r < A.length - 1 && A[r] > A[r + 1]) {
                r++;
                max = Math.max(max, r - l + 1);
            }
            l = r;
        }

        return max;
    }
}
