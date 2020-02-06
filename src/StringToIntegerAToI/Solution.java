package StringToIntegerAToI;

class Solution {
    public int myAtoi(String str) {
        if (str.length() < 1)
            return 0;
        int num = 0, i = 0, sign = 1;
        for (; i < str.length() && str.charAt(i) == ' '; i++)
            ;

        if (i >= str.length())
            return num;

        char potentialSign = str.charAt(i);
        if (potentialSign == '+' || potentialSign == '-') {
            if (potentialSign == '-')
                sign = -1;
            i++;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && str.charAt(i) - '7' > 0)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + str.charAt(i) - '0';
            i++;
        }

        return sign * num;
    }
}
