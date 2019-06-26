package ReverseWordsInAString;

import java.util.*;

class Solution {
    public String reverseWords(String s) {
        s = cleanSpaces(s);

        char[] c = s.toCharArray();

        reverse(c, 0, c.length - 1);

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

    private String cleanSpaces(String s) {
        String[] tokens = s.trim().split(" +");

        return String.join(" ", tokens);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;

            i++;
            j--;
        }
    }

    public String reverseWords2(String s) {
        String[] tokens = s.trim().split(" +");
        Collections.reverse(Arrays.asList(tokens));
        return String.join(" ", tokens);
    }

    public String reverseWords3(String s) {
        String[] arr = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].isEmpty()) {
                continue;
            }

            sb.append(arr[i]);

            if (i > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
