package RepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String pattern = s.substring(i, i + 10);
            if (seen.contains(pattern))
                repeated.add(pattern);
            seen.add(pattern);
        }

        return new ArrayList<>(repeated);
    }

    public List<String> findRepeatedDnaSequencesRollingHash(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 11)
            return res;

        Set<Integer> seen = new HashSet<>();
        Set<Integer> repeated = new HashSet<>();

        // Map ACGT to 0123
        int[] mapping = new int[26];
        mapping['A' - 'A'] = 0;
        mapping['C' - 'A'] = 1;
        mapping['G' - 'A'] = 2;
        mapping['T' - 'A'] = 3;

        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash <<= 2;
            hash = hash | mapping[s.charAt(i) - 'A'];
            hash = hash & 0xfffff; // We only need the last 20 bits

            if (i < 9)
                continue;

            if (!seen.add(hash) && repeated.add(hash))
                res.add(s.substring(i - 9, i + 1));
        }

        return res;
    }
}
