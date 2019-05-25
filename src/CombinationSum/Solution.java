package CombinationSum;

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(res, new ArrayList<Integer>(), candidates, target, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            comb.add(candidates[i]);
            backtrack(res, comb, candidates, target - candidates[i], i);
            comb.remove(comb.size() - 1);
        }
    }
}
