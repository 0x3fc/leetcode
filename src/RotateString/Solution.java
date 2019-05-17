package RotateString;

class Solution {
    // Another solution is KMP (Knuth-Morris-Pratt)

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.length() < 1) {
            return true;
        }

        char start = A.charAt(0);

        for (int j = 0; j < B.length(); j++) {
            if (B.charAt(j) != start) {
                continue;
            }

            int bIter = j, aIter = 0;

            boolean found = true;

            for (; aIter < A.length(); aIter++, bIter++) {
                if (A.charAt(aIter) != B.charAt(bIter % A.length())) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return true;
            }
        }


        return false;
    }
}
