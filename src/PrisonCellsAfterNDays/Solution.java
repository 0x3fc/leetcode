package PrisonCellsAfterNDays;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> seen = new HashMap<>();

        int state = 0;

        for (int i = 0; i < 8; i++) {
            state <<= 1;

            if (cells[i] == 1) {
                state ^= 1;
            }
        }

        while (N > 0) {
            if (seen.containsKey(state)) {
                N %= seen.get(state) - N;
            }

            seen.put(state, N);

            if (N >= 1) {
                N--;
                state = next(state);
            }
        }

        int[] res = new int[8];

        for (int i = 7; i >= 0; i--, state >>= 1) {
            res[i] = state & 1;
        }

        return res;
    }

    private int next(int state) {
        int nextState = 0;

        for (int i = 1; i < 7; i++) {
            int left = (state >> (i - 1)) & 1;
            int right = (state >> (i + 1)) & 1;

            if (left == right) {
                nextState ^= 1 << i;
            }
        }

        return nextState;
    }
}