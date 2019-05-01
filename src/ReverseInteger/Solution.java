package ReverseInteger;

class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;

        if (isNeg) {
            x = -x;
        }

        long sum = 0;
        int b;

        while (x > 0) {
            b = x % 10;
            x = x / 10;

            sum = sum * 10 + b;
        }

        if (isNeg) {
            sum = -sum;
        }

        boolean overflowed = sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE;

        return overflowed ? 0 : (int) sum;
    }
}
