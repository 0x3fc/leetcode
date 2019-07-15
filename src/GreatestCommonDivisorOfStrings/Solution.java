package GreatestCommonDivisorOfStrings;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len = gcd(str1.length(), str2.length());
        String pattern = str1.substring(0, len);

        return isComposedBy(str1, pattern) && isComposedBy(str2, pattern) ? pattern : "";
    }

    private int gcd(int n1, int n2) {
        // Euclid's algorithm
        return n2 == 0 ? n1 : gcd(n2, n1 % n2);
    }

    private boolean isComposedBy(String c, String pattern) {
        if (c.isEmpty()) {
            return true;
        }

        if (c.startsWith(pattern)) {
            return isComposedBy(c.substring(pattern.length()), pattern);
        }

        return false;
    }

    public String gcdOfStrings2(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings2(str2, str1);
        }

        return helper(str1, str2);
    }

    private String helper(String str1, String str2) {
        if (str2.isEmpty()) {
            return str1;
        }

        if (str1.length() < str2.length()) {
            return helper(str2, str1);
        }

        return str1.substring(0, str2.length()).equals(str2)
                ? helper(str2, str1.substring(str2.length(), str1.length()))
                : "";
    }
}
