package CoinChange;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] opt = new int[amount + 1];

        opt[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            opt[i] = amount + 1;
        }

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                opt[i] = Math.min(opt[i], opt[i - coin] + 1);
            }
        }

        return opt[amount] == amount + 1 ? -1 : opt[amount];
    }
}
