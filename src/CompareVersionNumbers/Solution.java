package CompareVersionNumbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        int maxLength = Math.max(v1s.length, v2s.length);
        for (int i = 0; i < maxLength; i++) {
            int v1 = i < v1s.length ? Integer.parseInt(v1s[i]) : 0;
            int v2 = i < v2s.length ? Integer.parseInt(v2s[i]) : 0;
            if (v1 != v2)
                return Integer.compare(v1, v2);
        }

        return 0;
    }
}
