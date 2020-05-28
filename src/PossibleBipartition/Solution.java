package PossibleBipartition;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer>[] graph;
    private int[] labels;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        // Initialize graph
        graph = new List[N + 1];
        for (int i = 1; i < N + 1; i++)
            graph[i] = new ArrayList<>();

        // Build graph
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        // Initialize labels
        labels = new int[N + 1];

        // DFS check is bipartition
        for (int node = 1; node < N + 1; node++) {
            int label = labels[node];
            if (label == 0 && !isBipartition(node, 1))
                return false;
        }

        return true;
    }

    private boolean isBipartition(int node, int label) {
        labels[node] = label;
        int altLabel = -label;

        for (int adjNode : graph[node]) {
            int adjLabel = labels[adjNode];

            if (adjLabel == label || (adjLabel == 0 && !isBipartition(adjNode, altLabel))) {
                return false;
            }
        }

        return true;
    }
}
