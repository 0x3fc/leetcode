package ImageOverlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;

        // Store all the 1's coord
        List<int[]> aCoords = new ArrayList<>();
        List<int[]> bCoords = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (A[r][c] == 1)
                    aCoords.add(new int[] { r, c });
                if (B[r][c] == 1)
                    bCoords.add(new int[] { r, c });
            }
        }

        int max = shiftAndCount(A, B, 0, aCoords);
        return shiftAndCount(B, A, max, bCoords);
    }

    private int shiftAndCount(int[][] A, int[][] B, int max, List<int[]> coords) {
        int N = A.length;

        for (int offr = 0; offr < N; offr++) {
            for (int offc = 0; offc < N; offc++) {
                // If total overlapping cell is less or equal to max, skip
                int w = N - offr;
                int h = N - offc;
                if (w * h <= max)
                    continue;

                int count = 0;
                for (int[] coord : coords) {
                    int r = coord[0] + offr;
                    int c = coord[1] + offc;
                    if (r < 0 || r >= N || c < 0 || c >= N || B[r][c] != 1)
                        continue;
                    count++;
                }
                max = Math.max(count, max);

                // If we found the max possible result, return it
                if (max == coords.size())
                    return max;
            }
        }

        return max;
    }

    public int largestOverlapBits(int[][] A, int[][] B) {
        int N = A.length;

        // Since N is smaller than 31, we can use int[] to represent int[][]
        int[] a = new int[N];
        int[] b = new int[N];
        int[] d = new int[N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                a[r] = (a[r] << 1) + A[r][c];
                b[r] = (b[r] << 1) + B[r][c];
                d[r] = (d[r] << 1) + B[r][c]; // Copy of b
            }
        }

        int max = shiftAndCount(b, a, 0);
        return shiftAndCount(a, d, max);
    }

    private int shiftAndCount(int[] A, int[] B, int max) {
        int N = A.length;

        for (int offc = 0; offc < N; offc++) {
            for (int offr = 0; offr < N; offr++) {
                // If total overlapping area is less or equal to max, skip
                int w = N - offr;
                int h = N - offc;
                if (w * h <= max)
                    continue;

                int count = 0;
                for (int ra = offr, rb = 0; ra < N; ra++, rb++) {
                    count += Integer.bitCount(A[ra] & B[rb]);
                }
                max = Math.max(count, max);
            }

            for (int r = 0; r < N; r++)
                A[r] <<= 1;
        }

        return max;
    }

    public int largestOverlapAllPossibleTransforms(int[][] A, int[][] B) {
        int N = A.length;

        // Flatten A and B; store the 1's key to a and b
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < N * N; i++) {
            int r = i / N;
            int c = i % N;
            int key = r * 100 + c;
            if (A[r][c] == 1)
                a.add(key);
            if (B[r][c] == 1)
                b.add(key);
        }

        // Map each 1s in a to each 1s in b
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : a) {
            for (int j : b) {
                // i - j is the transform
                counts.put(i - j, counts.getOrDefault(i - j, 0) + 1);
            }
        }

        // Find the maximum counts in each transform
        int max = 0;
        for (int count : counts.values()) {
            max = Math.max(count, max);
        }
        return max;
    }
}
