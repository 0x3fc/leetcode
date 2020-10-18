package BestTimeToBuyAndSellStockIV;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0)
            return 0;
        if (k >= prices.length / 2)
            return infiniteTransactions(prices);

        int[][] opt = new int[k + 1][prices.length];

        for (int i = 1; i <= k; i++) {
            // Find the cheapest buying timing
            int cheapest = Integer.MIN_VALUE;
            for (int j = 1; j < prices.length; j++) {
                // opt[i - 1][j - 1] means buying the stock at j - 1,
                // and we still can do 1 selling at opt[i][j]
                cheapest = Math.max(cheapest, opt[i - 1][j - 1] - prices[j - 1]);
                opt[i][j] = Math.max(opt[i][j - 1], cheapest + prices[j]);
            }
        }

        return opt[k][prices.length - 1];
    }

    private int infiniteTransactions(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = Math.max(max, max - prices[i] + prices[i + 1]);
        }
        return max;
    }
}
