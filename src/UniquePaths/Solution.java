package UniquePaths;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] opt = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    opt[i][j] = 1;
                    continue;
                }

                opt[i][j] = opt[i - 1][j] + opt[i][j - 1];
            }
        }

        return opt[m - 1][n - 1];
    }
}
