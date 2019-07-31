package Permutations;

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] candidates, boolean[] exists) {
        if (comb.size() == candidates.length) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (exists[i]) {
                continue;
            }

            comb.add(candidates[i]);
            exists[i] = true;
            backtrack(res, comb, candidates, exists);
            comb.remove(comb.size() - 1);
            exists[i] = false;
        }
    }
}
