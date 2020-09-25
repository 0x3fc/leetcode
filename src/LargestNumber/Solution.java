package LargestNumber;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return "";

        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String comb1 = s1 + s2;
                String comb2 = s2 + s1;
                return comb2.compareTo(comb1);
            }
        };

        Arrays.sort(s, comp);

        // If all 0, return 0
        if (s[0].charAt(0) == '0')
            return "0";

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            res.append(s[i]);
        }

        return res.toString();
    }
}
