package InsertInterval;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] { newInterval };

        int i = 0, start = newInterval[0], end = newInterval[1];
        List<int[]> res = new ArrayList<>();

        while (i < intervals.length && intervals[i][1] < start) {
            res.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[] { start, end });

        while (i < intervals.length) {
            res.add(intervals[i++]);
        }

        int[][] ans = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            ans[j] = res.get(j);
        }
        return ans;
    }
}
