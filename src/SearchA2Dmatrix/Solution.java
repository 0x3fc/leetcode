package SearchA2Dmatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && matrix[row][col] < target)
            row++;
        if (row == matrix.length)
            return false;
        while (col >= 0 && matrix[row][col] > target)
            col--;
        return col >= 0 && matrix[row][col] == target;
    }
}
