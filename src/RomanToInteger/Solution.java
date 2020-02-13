package RomanToInteger;

class Solution {
    static int[] map = new int[256];
    static {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
    }

    public int romanToInt(String s) {
        int last = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = map[s.charAt(i)];
            sum += curr >= last ? curr : -curr;
            last = curr;
        }
        return sum;
    }
}
