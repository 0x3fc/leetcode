package LicenseKeyFormatting;

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "").toUpperCase();
        int len = S.length();

        if (len <= K) {
            return S;
        }

        StringBuilder ans = new StringBuilder();
        int i = 0;

        for (; i < len % K; i++) {
            ans.append(S.charAt(i));
        }

        if (len % K != 0) {
            ans.append("-");
        }

        int count = K;

        for (; i < len; i++) {
            if (count == 0) {
                ans.append("-");
                count = K;
            }

            ans.append(S.charAt(i));

            count--;
        }

        return ans.toString();
    }
}
