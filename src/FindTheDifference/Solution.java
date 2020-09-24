package FindTheDifference;

class Solution {
    public char findTheDifference(String s, String t) {
        char diff = t.charAt(t.length() - 1);
        
        for (int i = 0; i < s.length(); i++) {
            diff ^= s.charAt(i);
            diff ^= t.charAt(i);
        }
        
        return diff;
    }
}
