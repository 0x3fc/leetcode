package NumbersWithSameConsecutiveDifferences;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1)
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        List<Integer> res = new ArrayList<>();

        for (int num = 1; num < 10; num++) {
            dfs(res, num, 1, N, K);
        }

        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }

    private void dfs(List<Integer> res, int num, int digit, int N, int K) {
        if (digit == N) {
            res.add(num);
            return;
        }

        int lastDigit = num % 10;

        if (lastDigit + K < 10) {
            dfs(res, num * 10 + lastDigit + K, digit + 1, N, K);
        }

        if (lastDigit - K >= 0 && K != 0) {
            dfs(res, num * 10 + lastDigit - K, digit + 1, N, K);
        }
    }
}
