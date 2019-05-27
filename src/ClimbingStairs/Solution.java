package ClimbingStairs;

class Solution {
    public int climbStairs(int n) {
        int o1 = 0;
        int o2 = 1;
        int res = 1;

        for (int i = 0; i < n; i++) {
            res = o1 + o2;
            o1 = o2;
            o2 = res;
        }

        return res;
    }
}
