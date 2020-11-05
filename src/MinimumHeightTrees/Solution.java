package MinimumHeightTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 2) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                res.add(i);
            return res;
        }

        List<Set<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (neighbors.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        int remaining = n;
        while (remaining > 2) {
            remaining -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int neighbor : neighbors.get(leaf)) {
                    neighbors.get(neighbor).remove(leaf);
                    if (neighbors.get(neighbor).size() == 1) {
                        newLeaves.add(neighbor);
                    }
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }
}
