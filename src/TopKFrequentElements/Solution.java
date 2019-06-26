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

    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int f = freq.get(num);

            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }

            bucket[f].add(num);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        return res.subList(0, k);
    }
}
