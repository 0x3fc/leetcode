package FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int dupIndex = num - 1;
            if (nums[dupIndex] < 0) {
                res.add(num);
            }
            nums[dupIndex] = -nums[dupIndex];
        }
        return res;
    }
}
