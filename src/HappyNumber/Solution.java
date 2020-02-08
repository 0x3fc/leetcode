package HappyNumber;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = nextNumber(slow);
            fast = nextNumber(fast);
            fast = nextNumber(fast);
            if (slow == 1 || fast == 1) return true;
        } while (slow != fast);

        return false;
    }

    public boolean isHappy2(int n) {
        Set<Integer> s = new HashSet<>();
        while (n != 1) {
            s.add(n);
            n = nextNumber(n);
            if (s.contains(n)) return false;
        }

        return true;
    }

    private int nextNumber(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
