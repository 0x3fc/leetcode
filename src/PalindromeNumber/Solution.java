package PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x <= 0) {
            return x == 0;
        }

        int res = 0;
        int original = x;

        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }

        return res == original;
    }
}
