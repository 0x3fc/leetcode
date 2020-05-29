package CountingBits;

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 1; i < res.length; i++) {
            res[i] = (i & 1) == 1 ? res[i - 1] + 1 // for all odd numbers, numOf1s(n) = numOf1s(n - 1) + 1
                    : res[i >> 1]; // for all even numbers, numOf1s(n) = numOf1s(n / 2)
        }

        return res;
    }
}
