package LargestComponentSizeByCommonFactor;

import java.util.Map;
import java.util.HashMap;

class Solution {
    private Map<Integer, Integer> parents;

    public int largestComponentSize(int[] A) {
        parents = new HashMap<>();

        for (int a : A) {
            for (int fact = 2; fact * fact <= a; fact++) {
                if (a % fact != 0)
                    continue;
                union(a, fact);
                union(a, a / fact);
            }
        }

        int max = 1;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : A) {
            int root = find(a);
            int f = freq.getOrDefault(root, 0) + 1;
            freq.put(root, f);
            max = Math.max(max, f);
        }

        return max;
    }

    public int find(int i) {
        if (!parents.containsKey(i))
            parents.put(i, i);
        int parent = parents.get(i);
        if (parent != i)
            parents.put(i, find(parent));
        return parents.get(i);
    }

    public void union(int i, int j) {
        int ri = find(i);
        int rj = find(j);
        if (ri < rj)
            parents.put(rj, ri);
        else
            parents.put(ri, rj);
    }
}
