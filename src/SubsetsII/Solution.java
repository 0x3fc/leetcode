package SubsetsII;

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(res, new ArrayList<>(), nums, 0);

        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> comb, int[] nums, int start) {
        res.add(new ArrayList<>(comb));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            comb.add(nums[i]);
            backtrack(res, comb, nums, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
