package MinCostClimbingStairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0;
        int f2 = 0;
        int res = 0;

        for (int i = 0; i < cost.length; i++) {
            res = cost[i] + Math.min(f1, f2);
            f1 = f2;
            f2 = res;
        }

        return Math.min(f1, f2);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int size = cost.length;

        int[] opt = new int[size];

        opt[0] = cost[0];
        opt[1] = cost[1];

        if (size <= 2) {
            return opt[size - 1];
        }

        for (int i = 2; i < size; i++) {
            opt[i] = cost[i] + Math.min(opt[i - 1], opt[i - 2]);
        }

        return Math.min(opt[size - 1], opt[size - 2]);
    }
}
