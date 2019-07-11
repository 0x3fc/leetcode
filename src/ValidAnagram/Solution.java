package ValidAnagram;

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] buckets = new int[26];

        for (char c : s.toCharArray()) {
            buckets[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            buckets[c - 'a']--;
        }

        for (int i : buckets) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        return (new String(sc)).equals(new String(tc));
    }
}
