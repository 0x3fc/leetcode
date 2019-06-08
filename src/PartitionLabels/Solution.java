package PartitionLabels;

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];

        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int lastIndex = 0;
        int start = -1;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            lastIndex = Math.max(lastIndex, last[S.charAt(i) - 'a']);

            if (lastIndex == i) {
                res.add(lastIndex - start);
                start = i;
            }
        }

        return res;
    }
}
