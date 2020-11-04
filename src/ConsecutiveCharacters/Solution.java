package ConsecutiveCharacters;

class Solution {
    public int maxPower(String s) {
        char e = s.charAt(0);
        int max = 1, count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == e) {
                count++;
                max = Math.max(max, count);
            } else {
                e = s.charAt(i);
                count = 1;
            }
        }
        return max;
    }
}
