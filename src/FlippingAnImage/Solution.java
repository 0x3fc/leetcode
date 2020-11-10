package FlippingAnImage;

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row : A) {
            int i = 0;
            int j = row.length - 1;

            while (i <= j) {
                int tmp = row[i];
                row[i++] = 1 - row[j];
                row[j--] = 1 - tmp;
            }
        }

        return A;
    }

    public int[][] flipAndInvertImageWhenNecessary(int[][] A) {
        int n = A.length;

        for (int[] row : A) {
            for (int i = 0; i * 2 < n; i++) {
                if (row[i] == row[n - i - 1]) {
                    row[i] = row[n - i - 1] ^= 1;
                }
            }
        }

        return A;
    }
}
