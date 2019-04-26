import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int maxLen = 0;

        for (int i = 0, j = 0; j < length; j++) {
            Character c = s.charAt(j);

            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }

            maxLen = Math.max(maxLen, j - i + 1);
            map.put(c, j + 1);
        }

        return maxLen;
    }
}
