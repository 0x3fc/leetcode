package TopKFrequentElements;

import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> frequencies.get(n2) - frequencies.get(n1));
        pq.addAll(frequencies.keySet());

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll());
        }

        return res;
    }
}
