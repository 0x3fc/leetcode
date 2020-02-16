package MaximumNumberOfEventsThatCanBeAttended;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int total = 0;
        int i = 0;

        for (int day = 1; day <= 100000; day++) {
            // Add events in current day
            while (i < events.length && events[i][0] == day) {
                pq.add(events[i++][1]);
            }

            // Remove all the expired events
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend earilest ending event
            if (!pq.isEmpty()) {
                pq.poll();
                total++;
            }
        }

        return total;
    }
}
