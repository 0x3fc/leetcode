package PowerOfThree;

class Solution {
    /**
     * In particular, n is of type int. In Java, this means it is a 4 byte, signed
     * integer. The maximum value of this data type is 2147483647.
     * 
     * Knowing the limitation of n, we can now deduce that the maximum value of n
     * that is also a power of three is 1162261467. We calculate this as:
     * 
     * 3 ^ (log3 MaxInt) = 3 ^ 19.56 = 3 ^ 19 = 1162261467
     * 
     * Therefore, the possible values of n where we should return true are 3 ^ 0, 3
     * ^ 1, ..., 3 ^ 19. Since 3 is a **prime** number, the only divisors of 3 ^ 19
     * are 3 ^ 0, 3 ^ 1, ..., 3 ^ 19, therefor all we need to do is divide 3 ^ 19 by
     * n. A remainder of 0 means n is a divisor of 3^{19}3 19 and therefore a power
     * of three.
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    /**
     * n = 3 ^ i
     * 
     * i = log3(n)
     * 
     * i = log10(n) / log10(3)
     * 
     * n is a power of three if and only if i is an integer. In Java, we check if a
     * number is an integer by taking the decimal part (using % 1) and checking if
     * it is 0.
     */
    public boolean isPowerOfThree2(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThree3(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
