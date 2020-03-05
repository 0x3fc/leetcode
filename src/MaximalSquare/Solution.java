package MaximalSquare;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];

        int maxLength = 0;
        int topLeft = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmpTopLeft = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    int top = dp[j];
                    int left = dp[j - 1];
                    dp[j] = Math.min(left, Math.min(top, topLeft)) + 1;
                } else {
                    dp[j] = 0;
                }
                maxLength = Math.max(maxLength, dp[j]);
                topLeft = tmpTopLeft;
            }
        }

        return maxLength * maxLength;
    }

    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];

        int maxLength = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    continue;
                }

                int topLeft = dp[i - 1][j - 1];
                int left = dp[i - 1][j];
                int top = dp[i][j - 1];

                dp[i][j] = Math.min(topLeft, Math.min(left, top)) + 1;

                maxLength = Math.max(dp[i][j], maxLength);
            }
        }

        return maxLength * maxLength;
    }
}
