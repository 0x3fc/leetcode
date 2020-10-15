package FindServersThatHandledMostNumberOfRequests;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> servers = new TreeSet<>();
        PriorityQueue<int[]> finishedAt = new PriorityQueue<>((a, b) -> a[0] - b[0]); // { finished time, server }
        
        int[] requests = new int[k];
        int maxRequestNum = 0;
        
        // All servers are available at the beginning
        for (int i = 0; i < k; i++) servers.add(i);
        
        // Simulate requests handling
        for (int i = 0; i < arrival.length; i++) {
            int arrivedAt = arrival[i];
            int duration = load[i];
            
            // Release finished servers
            while (finishedAt.size() > 0 && finishedAt.peek()[0] <= arrivedAt) servers.add(finishedAt.poll()[1]);
            
            // If no server is available, drop the request
            if (servers.size() == 0) continue;
            
            // Find the available server
            Integer server = servers.ceiling(i % k);
            if (server == null) server = servers.ceiling(0);
            
            servers.remove(server);
            finishedAt.offer(new int[] { arrivedAt + duration, server });
            
            requests[server]++;
            maxRequestNum = Math.max(maxRequestNum, requests[server]);
            
        }
        
        // Find the busiest server
        List<Integer> busiests = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequestNum) busiests.add(i);
        }
        
        return busiests;
    }
}
