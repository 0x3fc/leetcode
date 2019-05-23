package CustomSortString;

class Solution {
    public String customSortString(String S, String T) {
        int length = T.length();
        char[] res = new char[length];
        int[] count = new int[256];
        int index = 0;

        for (int i = 0; i < length; i++) {
            count[T.charAt(i)]++;
        }

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            while (count[c] > 0) {
                res[index++] = c;
                count[c]--;
            }
        }

        for (int i = 97; i < 123; i++) {
            while (count[i] > 0) {
                res[index++] = (char) i;
                count[i]--;
            }
        }

        return new String(res);
    }
}
