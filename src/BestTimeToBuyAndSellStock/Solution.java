package BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int min = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(prices[i], min);
        }

        return max;
    }
}
