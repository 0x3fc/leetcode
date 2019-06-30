package FlowerPlantingWithNoAdjacent;

import java.util.*;

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N];
        Arrays.fill(res, 1);

        boolean conflict;

        do {
            conflict = false;

            for (int[] path : paths) {
                int u = Math.min(path[0], path[1]) - 1;
                int v = Math.max(path[0], path[1]) - 1;

                if (res[u] == res[v]) {
                    conflict = true;
                    res[v] = (res[u] % 4) + 1;
                }
            }
        } while (conflict);

        return res;
    }

    public int[] gardenNoAdj2(int N, int[][] paths) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }

        for (int[] p : paths) {
            graph.get(p[0] - 1).add(p[1] - 1);
            graph.get(p[1] - 1).add(p[0] - 1);
        }

        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            boolean[] taken = new boolean[5];

            for (int neighbour : graph.get(i)) {
                taken[res[neighbour]] = true;
            }

            for (int color = 1; color <= 4; color++) {
                if (!taken[color]) {
                    res[i] = color;
                    break;
                }
            }
        }

        return res;
    }
}
