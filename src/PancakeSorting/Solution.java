package PancakeSorting;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i >= 0; i--) {
            int j = i;
            for (; A[j] != i + 1; j--);
            if (i == j) {
                continue;
            }
            reverse(A, j);
            reverse(A, i);
            res.add(j + 1);
            res.add(i + 1);
        }
        return res;
    }

    private void reverse(int[] A, int end) {
        int start = 0;
        while (start < end) {
            int tmp = A[start];
            A[start] = A[end];
            A[end] = tmp;
            start++;
            end--;
        }
    }
}
