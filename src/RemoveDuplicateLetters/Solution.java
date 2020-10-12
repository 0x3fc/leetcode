package RemoveDuplicateLetters;

import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0)
            return "";

        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i) - 'a']++;

        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(startIndex))
                startIndex = i;
            counts[s.charAt(i) - 'a']--;
            if (counts[s.charAt(i) - 'a'] <= 0)
                break;
        }

        String newSearchString = s.substring(startIndex + 1).replaceAll("" + s.charAt(startIndex), "");

        return s.charAt(startIndex) + removeDuplicateLetters(newSearchString);
    }

    // Using stack

    public String removeDuplicateLettersWithStack(String s) {
        if (s.length() == 0)
            return "";

        boolean[] visited = new boolean[26];
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++)
            counts[s.charAt(i) - 'a']++;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            while (!stack.empty() && counts[stack.peek() - 'a'] > 0 && !visited[c - 'a'] && c < stack.peek()) {
                visited[stack.pop() - 'a'] = false;
            }

            if (!visited[c - 'a']) {
                stack.push(c);
                visited[c - 'a'] = true;
            }

            counts[c - 'a']--;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
