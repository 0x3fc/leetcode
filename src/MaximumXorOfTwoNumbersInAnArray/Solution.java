package MaximumXorOfTwoNumbersInAnArray;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            // We want to look for a 1 in current bit as the greedy try
            int greedyTry = max | (1 << i);
            for (int prefix : prefixes) {
                // Check if we have a pair which gives us greedy try in nums
                if (prefixes.contains(prefix ^ greedyTry)) {
                    max = greedyTry;
                    break;
                }
            }
        }

        return max;
    }

    // Using Trie

    class Trie {
        public Trie[] children = new Trie[2];
    }

    public int findMaximumXORWithTrie(int[] nums) {
        int max = 0;
        Trie root = new Trie();

        for (int num : nums) {
            Trie curr = root, complement = root;
            int localMax = 0;

            for (int i = 31; i >= 0; i--) {
                int mask = 1 << i;
                int bit = (num & mask) == 0 ? 0 : 1;

                if (curr.children[bit] == null)
                    curr.children[bit] = new Trie();
                curr = curr.children[bit];

                // Greedy find the largest pair of current number within previous seen numbers
                if (complement.children[1 - bit] == null) {
                    complement = complement.children[bit];
                } else {
                    complement = complement.children[1 - bit];
                    localMax |= mask;
                }
            }

            max = Math.max(localMax, max);
        }

        return max;
    }
}
