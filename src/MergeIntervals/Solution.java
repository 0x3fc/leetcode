package MergeIntervals;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            max = Math.max(max, interval[1]);
            min = Math.min(min, interval[0]);
        }

        List<int[]>[] buckets = new ArrayList[max - min + 1];

        for (int[] interval : intervals) {
            int index = interval[0] - min;

            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }

            buckets[index].add(interval);
        }

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) {
                continue;
            }

            for (int[] interval : buckets[i]) {
                if (merged.size() == 0) {
                    merged.add(interval);
                    continue;
                }

                int[] lastInterval = merged.get(merged.size() - 1);

                if (lastInterval[1] < interval[0]) {
                    merged.add(interval);
                    continue;
                }

                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        int[][] res = merged.toArray(new int[][] {});

        return res;
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (n1, n2) -> Integer.compare(n1[0], n2[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (end >= interval[0]) {
                end = Math.max(interval[1], end);
            } else {
                mergedIntervals.add(new int[] { start, end });
                start = interval[0];
                end = interval[1];
            }
        }

        mergedIntervals.add(new int[] { start, end });

        int[][] res = mergedIntervals.toArray(new int[][] {});

        return res;
    }
}
