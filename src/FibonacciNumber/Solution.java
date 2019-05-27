package FibonacciNumber;

class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int f1 = 0;
        int f2 = 1;
        int res = 1;

        for (int i = 1; i < N; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }

        return res;
    }
}
