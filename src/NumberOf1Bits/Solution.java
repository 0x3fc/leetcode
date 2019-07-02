package NumberOf1Bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }

    public int hammingWeight2(int n) {
        int sum = 0;

        while (n != 0) {
            sum++;
            n &= (n - 1);
        }

        return sum;
    }
}
