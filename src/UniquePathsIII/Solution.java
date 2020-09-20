package UniquePathsIII;

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int count = 0, sr = 0, sc = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    count++;
                } else if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                }
            }
        }

        return dfs(grid, sr, sc, count + 1);
    }

    private int dfs(int[][] grid, int r, int c, int count) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == -1)
            return 0;

        if (count == 0)
            return grid[r][c] == 2 ? 1 : 0;

        int orig = grid[r][c];
        grid[r][c] = -1;

        int left = dfs(grid, r - 1, c, count - 1);
        int right = dfs(grid, r + 1, c, count - 1);
        int up = dfs(grid, r, c - 1, count - 1);
        int down = dfs(grid, r, c + 1, count - 1);

        grid[r][c] = orig;

        return left + right + up + down;
    }
}
