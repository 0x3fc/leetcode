package FirstUniqueCharacterInAString;

class Solution {
    public int firstUniqChar(String s) {
        int[] seen = new int[26];
        char[] cs = s.toCharArray();

        for (char c : cs) {
            seen[c - 'a'] += 1;
        }

        for (int i = 0; i < cs.length; i++) {
            if (seen[cs[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
