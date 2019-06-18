package RotateImage;

class Solution {
    public void rotate(int[][] matrix) {
        int s = 0;
        int e = matrix.length - 1;

        while (s < e) {
            int[] tmp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = tmp;

            s++;
            e--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
