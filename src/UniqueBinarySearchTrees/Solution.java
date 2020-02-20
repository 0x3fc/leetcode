package UniqueBinarySearchTrees;

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int l = 0, r = i - 1;
            while (l < i) {
                sum += dp[l++] * dp[r--];
            }
            dp[i] = sum;
        }

        return dp[n];
    }
}
