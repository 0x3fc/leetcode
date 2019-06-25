package ReverseWordsInAStringIII;

class Solution {
    public String reverseWords(String s) {
        char[] c = s.toCharArray();

        int start = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                reverse(c, start, i - 1);
                start = i + 1;
            }
        }

        reverse(c, start, c.length - 1);

        return new String(c);
    }

    private void reverse(char[] c, int s, int e) {
        while (s < e) {
            char tmp = c[s];
            c[s] = c[e];
            c[e] = tmp;

            s++;
            e--;
        }
    }
}
