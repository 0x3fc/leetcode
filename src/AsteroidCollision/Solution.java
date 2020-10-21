package AsteroidCollision;

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];

            // Push asteroid and continue when
            // 1. asteroid going right side, or
            // 2. there is no asteroid, or
            // 3. the asteroids are all going towards left
            if (a > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.add(a);
            }

            // Cases that should destroy at least one asteroid in stack
            else if (stack.peek() <= -a) {
                // Destroy one in the stack and continue on the current asteroid
                if (stack.pop() < -a)
                    i--;
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
