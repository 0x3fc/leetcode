package SearchA2DMatrixII;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row < matrix.length) {
            int current = matrix[row][col];

            if (current == target) {
                return true;
            }

            if (current > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
