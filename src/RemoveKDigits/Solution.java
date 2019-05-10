package RemoveKDigits;

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        int size = num.length();

        int remain = size - k;
        char[] res = new char[remain];
        int i = 0;

        for (int j = 0; j < size; j++) {
            // (1)  (n - j > remain - i): have enough remaining digits to be compared
            // (2)  (res[i - 1] > nums[j]): at this time, the (i-1) is the newest added digit,
            //      compare this digit with the current num, if the res is greater and you have enough
            //      remaining digits to be compared, decrease the i (it ensures that the future added digit is
            //      always smaller than before and the size is remain) until get the right and 'safe' position
            while ((size - j > remain - i) && (i > 0 && num.charAt(j) < res[i - 1])) {
                i--;
            }

            if (i < remain) {
                res[i++] = num.charAt(j);
            }
        }

        // check leading zeroes
        i = -1;

        while (++i < remain) {
            if (res[i] != '0') break;
        }

        String s = new String(res).substring(i);

        return s.length() == 0 ? "0" : s;
    }

    public String removeKdigits2(String num, int k) {
        int size = num.length();

        if (size == 0) return "0";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
