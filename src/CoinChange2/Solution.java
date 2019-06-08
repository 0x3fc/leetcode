package CoinChange2;

class Solution {
    public int change(int amount, int[] coins) {
        int[] opt = new int[amount + 1];

        opt[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                opt[i] += opt[i - coin];
            }
        }

        return opt[amount];
    }
}
