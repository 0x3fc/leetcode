package RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Cell {
        int i;
        int j;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Cell> rottonOranges = new LinkedList<>();

        // Add all rotton oranges to queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottonOranges.add(new Cell(i, j));
                }
            }
        }

        int time = 0;

        while (!rottonOranges.isEmpty()) {
            int size = rottonOranges.size();
            boolean rottonAny = false;

            for (int i = 0; i < size; i++) {
                Cell cell = rottonOranges.poll();
                rottonAny = pollute(grid, cell, rottonOranges, 1, 0) || rottonAny;
                rottonAny = pollute(grid, cell, rottonOranges, -1, 0) || rottonAny;
                rottonAny = pollute(grid, cell, rottonOranges, 0, 1) || rottonAny;
                rottonAny = pollute(grid, cell, rottonOranges, 0, -1) || rottonAny;
            }

            if (rottonAny) {
                time++;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }

    private boolean pollute(int[][] grid, Cell cell, Queue<Cell> rottonOranges, int i, int j) {
        i = i + cell.i;
        j = j + cell.j;

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return false;
        }

        grid[i][j] = 2;
        rottonOranges.add(new Cell(i, j));
        return true;
    }
}
