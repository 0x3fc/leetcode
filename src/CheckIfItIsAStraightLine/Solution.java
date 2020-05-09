package CheckIfItIsAStraightLine;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return true;
        }

        int x_t = coordinates[1][0] - coordinates[0][0];
        int y_t = coordinates[1][1] - coordinates[0][1];

        for (int i = 2; i < coordinates.length; i++) {
            int x_i = coordinates[i][0] - coordinates[0][0];
            int y_i = coordinates[i][1] - coordinates[0][1];
            int det = x_t * y_i - x_i * y_t;

            if (det != 0) {
                return false;
            }
        }

        return true;
    }
}
