package CombinationSumII;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];

            if (candidate > target) {
                break;
            }

            // Skip duplicates
            if (i > start && candidate == candidates[i - 1]) {
                continue;
            }

            comb.add(candidate);
            backtrack(res, comb, candidates, target - candidate, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
