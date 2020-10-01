package NumberOfRecentCalls;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests = new LinkedList<>();
    private final int INTERVAL = 3000;

    public int ping(int t) {
        while (requests.size() > 0 && requests.peek() < t - INTERVAL)
            requests.poll();
        requests.offer(t);
        return requests.size();
    }
}
