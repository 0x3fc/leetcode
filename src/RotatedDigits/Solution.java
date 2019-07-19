package RotatedDigits;

class Solution {
    public int rotatedDigits(int N) {
        int[] opt = new int[N + 1];
        int count = 0;

        for (int i = 0; i <= N; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    opt[i] = 1; // Valid but the same
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    opt[i] = 2; // Valid and different
                    count++;
                }
            } else {
                int builtUpResult = opt[i / 10];
                int lastBit = opt[i % 10];

                if (builtUpResult == 1 && lastBit == 1) {
                    opt[i] = 1;
                } else if (builtUpResult >= 1 && lastBit >= 1) {
                    opt[i] = 2;
                    count++;
                }
            }
        }

        return count;
    }

    private int[] allPossibleCount = new int[] { 1, 2, 3, 3, 3, 4, 5, 5, 6, 7 }; // 0,1,2,5,6,8,9
    private int[] excludeNumCount = new int[] { 1, 2, 2, 2, 2, 2, 2, 2, 3, 3 }; // 0, 1, 8
    private boolean[] isValid = new boolean[] { true, true, true, false, false, true, true, false, true, true }; // 0,1,2,5,6,8,9
    private boolean[] isExclude = new boolean[] { true, true, false, false, false, false, false, false, true, false }; // 0,1,8

    public int rotatedDigits2(int N) {
        char[] cs = Integer.toString(N).toCharArray();
        int len = cs.length, count = 0;
        boolean exclude = true;
        int base7 = (int) Math.pow(7, len - 1), base3 = (int) Math.pow(3, len - 1);
        for (int i = 0; i < len; i++, base7 /= 7, base3 /= 3) {
            if (cs[i] == '0' && i != len - 1)
                continue;
            int index = i == len - 1 ? cs[i] - '0' : cs[i] - '0' - 1;
            double c = allPossibleCount[index] * base7;
            double e = exclude ? excludeNumCount[index] * base3 : 0; // # of numbers which only contain 0,1,8
            count += c - e;
            if (!isValid[cs[i] - '0'])
                break;
            exclude = exclude & isExclude[cs[i] - '0'];
        }
        return count;
    }
}
