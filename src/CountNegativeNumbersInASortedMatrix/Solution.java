package CountNegativeNumbersInASortedMatrix;

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int total = 0;
        int i = m - 1;

        for (int j = 0; j < n; j++) {
            while (i >= 0 && grid[i][j] < 0) i--;
            total += m - i - 1;
        }

        return total;
    }
}
