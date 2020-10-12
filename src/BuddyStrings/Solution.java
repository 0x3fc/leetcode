package BuddyStrings;

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2)
            return false;

        if (A.equals(B)) {
            int[] counts = new int[26];
            for (int i = 0; i < A.length(); i++) {
                counts[A.charAt(i) - 'a']++;
                if (counts[A.charAt(i) - 'a'] >= 2)
                    return true;
            }
            return false;
        }

        int diffCount = 0;
        int[] diff = new int[2];

        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a == b)
                continue;
            diffCount++;
            if (diffCount > 2)
                return false;
            diff[diffCount - 1] = i;
        }

        return A.charAt(diff[0]) == B.charAt(diff[1]) && A.charAt(diff[1]) == B.charAt(diff[0]);
    }
}
