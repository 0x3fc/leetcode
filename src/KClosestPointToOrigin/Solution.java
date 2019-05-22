package KClosestPointToOrigin;

import java.util.Arrays;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int i = 0;
        int j = points.length - 1;

        while (i < j) {
            int p = quickSelect(points, i, j);

            if (p == K) {
                break;
            }

            if (p < K) {
                i = p;
            } else {
                j = p - 1;
            }
        }

        return Arrays.copyOf(points, K);
    }

    private int quickSelect(int[][] points, int i, int j) {
        int mid = (i + j) / 2;
        int[] pivot = points[mid];

        while (i <= j) {
            while (compare(points[i], pivot) < 0) {
                i++;
            }

            while (compare(points[j], pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(points, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}
