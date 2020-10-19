package MinimumDominoRotationsForEqualRow;

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int count1 = count(A[0], A, B);
        int count2 = count(B[0], A, B);

        return count1 == -1 || count2 == -1 ? Math.max(count1, count2) : Math.min(count1, count2);
    }

    private int count(int e, int[] A, int[] B) {
        int swap1 = 0;
        int swap2 = 0;

        for (int i = 0; i < A.length; i++) {
            if (e != A[i] && e != B[i])
                return -1;

            if (e != A[i])
                swap1++;
            if (e != B[i])
                swap2++;
        }

        return Math.min(swap1, swap2);
    }

    public int minDominoRotationsMathWay(int[] A, int[] B) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        int n = A.length;

        for (int i = 0; i < n; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i])
                same[A[i]]++;
        }

        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == n)
                return n - Math.max(countA[i], countB[i]);
        }

        return -1;
    }
}
