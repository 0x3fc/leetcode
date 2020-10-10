package BurstBalloons;

import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int count = 0;
        Integer last = null;
        for (int[] point : points) {
            if (last != null && point[0] <= last && point[1] >= last)
                continue;
            count++;
            last = point[1];
        }
        return count;
    }
}
