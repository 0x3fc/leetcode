package SummaryRanges;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1)
                i++;

            res.add(start == nums[i] ? "" + start : "" + start + "->" + nums[i]);
        }

        return res;
    }
}
