package ChampagneTower;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] tower = new double[query_row + 1];
        tower[0] = poured;

        for (int row = 1; row <= query_row; row++) {
            for (int i = row - 1; i >= 0; i--) {
                tower[i] = Math.max(0.0, (tower[i] - 1) / 2);
                tower[i + 1] += tower[i];
            }
        }

        return Math.min(tower[query_glass], 1.0);
    }
}
