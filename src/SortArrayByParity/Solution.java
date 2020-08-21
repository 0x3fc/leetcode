package SortArrayByParity;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int even = 0;
        int odd = A.length - 1;
        int[] res = new int[A.length];

        for (int x : A) {
            if ((x & 1) == 1) {
                res[odd--] = x;
            } else {
                res[even++] = x;
            }
        }

        return res;
    }

    public int[] sortArrayByParityInPlace(int[] A) {
        int j = A.length - 1;

        for (int i = 0; i < A.length && i < j; i++) {
            while (j > i && (A[j] & 1) == 1) {
                j--;
            }

            if ((A[i] & 1) == 1) {
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
            }
        }

        return A;
    }
}
