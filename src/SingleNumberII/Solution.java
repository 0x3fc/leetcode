package SingleNumberII;

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;

        for (int num : nums) {
            a = a ^ num & ~b;
            b = b ^ num & ~a;
        }

        return a | b;
    }

    public int singleNumber2(int[] nums) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int bitSum = 0;

            for (int num : nums) {
                bitSum += getBit(num, i);
            }

            bitSum %= 3;

            if (bitSum != 0) {
                res |= bitSum << i;
            }
        }

        return res;
    }

    private int getBit(int num, int digit) {
        return num >> digit & 1;
    }
}
