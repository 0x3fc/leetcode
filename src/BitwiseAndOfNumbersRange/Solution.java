package BitwiseAndOfNumbersRange;

class Solution {
    public int rangeBitwiseAnd2(int m, int n) {
        int count = 0;
        int mask = 1 << 31;

        for (; count < 32 && (mask & n) == 0; count++) {
            mask >>>= 1;
        }

        int ans = 0;

        for (; count < 32 && (mask & (m ^ n)) == 0; count++) {
            ans |= mask & m;
            mask >>>= 1;
        }

        return ans;
    }

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }

        int flag = 1;

        while (m != n) {
            m >>= 1;
            n >>= 1;

            flag <<= 1;
        }

        return flag * m;
    }
}
