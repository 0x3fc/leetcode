package ImplementRand10UsingRand7;

import java.util.Random;

class SolBase {
    public int rand7() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}

class Solution extends SolBase {
    public int rand10() {
        int oddEven, base;

        do {
            oddEven = rand7();
        } while (oddEven == 7);

        do {
            base = rand7();
        } while (base > 5);

        return (oddEven & 1) == 1 ? base : base + 5;
    }

    public int rand10_2() {
        while (true) {
            int r = 7 * (rand7() - 1) + (rand7() - 1);
            if (r < 40) {
                return r % 10 + 1;
            }
        }
    }
}
