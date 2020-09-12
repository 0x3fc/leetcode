package CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> cur, int k, int n, int i) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (k == 0 || n < i || i > 9)
            return;

        for (int j = i; j < 10; j++) {
            cur.add(j);
            backtrack(res, cur, k - 1, n - j, j + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
