package UncrossedLines;

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] opt = new int[A.length + 1][B.length + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                opt[i + 1][j + 1] = Math.max(opt[i][j + 1], opt[i + 1][j]);

                if (A[i] == B[j]) {
                    opt[i + 1][j + 1] = Math.max(opt[i + 1][j + 1], opt[i][j] + 1);
                }
            }
        }

        return opt[A.length][B.length];
    }
}
