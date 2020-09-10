package RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Create two Disjoint Union Find parent arrays
        int[] parents1 = new int[n + 1];
        int[] parents2 = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parents1[i] = i;
            parents2[i] = i;
        }

        // Keep tracking of each Disjoint Union Find edges and total removals
        int[] edgeCount = new int[3]; // index 1 -> parent1, index 2 -> parent2
        int totalRemoval = 0;

        // Remove redundent type 3
        for (int[] edge : edges) {
            if (edge[0] != 3)
                continue;

            boolean merged = merge(parents1, edge[1], edge[2]);
            merge(parents2, edge[1], edge[2]);

            if (merged) {
                edgeCount[1]++;
                edgeCount[2]++;
            } else { // If not able to merge, the graph is already connected
                totalRemoval++;
            }
        }

        // Remove redundent type 1 and 2
        for (int[] edge : edges) {
            if (edge[0] == 3)
                continue;
            int[] parents = edge[0] == 1 ? parents1 : parents2;
            boolean merged = merge(parents, edge[1], edge[2]);
            if (merged)
                edgeCount[edge[0]]++;
            else
                totalRemoval++;
        }

        // To be fully traversable, both graphs should be spanning trees
        boolean fullyTraversable = (edgeCount[1] == n - 1) && (edgeCount[2] == n - 1);
        return fullyTraversable ? totalRemoval : -1;
    }

    private boolean merge(int[] parents, int i, int j) {
        int p1 = find(parents, i);
        int p2 = find(parents, j);
        if (p1 == p2)
            return false;
        parents[p1] = p2;
        return true;
    }

    private int find(int[] parents, int i) {
        if (parents[i] == i)
            return i;
        parents[i] = find(parents, parents[i]);
        return parents[i];
    }
}
