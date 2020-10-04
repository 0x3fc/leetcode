package RemoveCoveredIntervals;

import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int right = -1, count = 0;

        for (int[] interval : intervals) {
            if (interval[1] <= right)
                continue;
            count++;
            right = interval[1];
        }

        return count;
    }
}
