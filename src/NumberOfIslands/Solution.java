package NumberOfIslands;

class Solution {
    private int totalRows;
    private int totalColumns;

    public int numIslands(char[][] grid) {
        if (grid.length < 1) {
            return 0;
        }

        int count = 0;

        totalRows = grid[0].length;
        totalColumns = grid.length;

        for (int i = 0; i < totalColumns; i++) {
            for (int j = 0; j < totalRows; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                count++;
                destroyIsland(grid, i, j);
            }
        }

        return count;
    }

    private void destroyIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= totalColumns || j >= totalRows || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        destroyIsland(grid, i + 1, j);
        destroyIsland(grid, i - 1, j);
        destroyIsland(grid, i, j + 1);
        destroyIsland(grid, i, j - 1);
    }
}
