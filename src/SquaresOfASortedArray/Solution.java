package SquaresOfASortedArray;

class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;

        int start = 0;
        int end = len - 1;

        int[] res = new int[len];

        int i = len - 1;

        while (start <= end) {
            int e = A[end];
            int s = -A[start];

            if (e > s) {
                res[i] = e * e;
                end--;
            } else {
                res[i] = s * s;
                start++;
            }

            i--;
        }

        return res;
    }
}
