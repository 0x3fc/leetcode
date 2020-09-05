package LargestTimeByGivenDigits;

class Solution {
    public String largestTimeFromDigits(int[] A) {
        String res = "";
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < A.length; k++) {
                    if (i == j || j == k || k == i)
                        continue;
                    String h = "" + A[i] + A[j];
                    String m = "" + A[k] + A[6 - i - j - k];
                    String t = h + ":" + m;
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && res.compareTo(t) < 0)
                        res = t;
                }
            }
        }
        return res;
    }
}
