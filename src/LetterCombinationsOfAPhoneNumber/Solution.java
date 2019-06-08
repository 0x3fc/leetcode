package LetterCombinationsOfAPhoneNumber;

import java.util.*;

class Solution {
    private static final char[][] m = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() < 1) {
            return res;
        }

        backtrack(res, new StringBuilder(), digits, 0);

        return res;
    }

    public void backtrack(List<String> res, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char[] candidates = m[digits.charAt(index) - '2'];

        for (int j = 0; j < candidates.length; j++) {
            sb.append(candidates[j]);
            backtrack(res, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
