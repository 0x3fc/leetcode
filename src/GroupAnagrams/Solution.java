package GroupAnagrams;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String charCount = buildCharCount(strs[i]);

            if (!anagrams.containsKey(charCount)) {
                anagrams.put(charCount, new ArrayList<>());
            }

            anagrams.get(charCount).add(strs[i]);
        }

        return new ArrayList<List<String>>(anagrams.values());
    }

    private String buildCharCount(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        return Arrays.toString(count);
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String order = new String(c);

            if (!anagrams.containsKey(order)) {
                anagrams.put(order, new ArrayList<>());
            }

            anagrams.get(order).add(s);
        }

        return new ArrayList<List<String>>(anagrams.values());
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        int[] prime = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
                89, 97, 101, 103 };

        Map<Integer, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            int key = 1;

            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }

            if (!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>());
            }

            anagrams.get(key).add(s);
        }

        return new ArrayList<List<String>>(anagrams.values());
    }
}
