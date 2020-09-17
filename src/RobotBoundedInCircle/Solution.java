package RobotBoundedInCircle;

class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0;
        int fx = 0, fy = 1;

        for (char inst : instructions.toCharArray()) {
            if (inst == 'G') {
                x += fx;
                y += fy;
            } else {
                int tmp = fx;
                fx = inst == 'L' ? -fy : fy;
                fy = inst == 'L' ? tmp : -tmp;
            }
        }

        // The robot stays in the circle iff (looking at the final vector)
        // it changes direction (ie. doesn't stay pointing north),
        // or it moves 0.
        return (x == 0 && y == 0) || (fx != 0 || fy != 1);
    }
}
