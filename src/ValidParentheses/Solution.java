package ValidParentheses;

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c == '(' ? c + 1 : c + 2);
                continue;
            }

            if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
