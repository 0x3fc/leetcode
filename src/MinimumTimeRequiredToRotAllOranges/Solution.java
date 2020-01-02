// https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
package MinimumTimeRequiredToRotAllOranges;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Cell {
        int x = 0;
        int y = 0;
        boolean isDelimiter;

        static final int EMPTY = 0;
        static final int FRESH = 1;
        static final int ROTTON = 2;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Cell(boolean isDelimiter) {
            this.isDelimiter = isDelimiter;
        }
    }

    private static int rotOranges(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return -1;
        }

        int col = matrix[0].length;
        if (col == 0) {
            return -1;
        }

        Queue<Cell> queue = new LinkedList<>();

        // Enqueue all the rotton orange
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == Cell.ROTTON) {
                    queue.add(new Cell(i, j));
                }
            }
        }

        int res = 0;

        queue.add(new Cell(true));

        while (!queue.isEmpty()) {
            boolean tick = false;

            while (!queue.peek().isDelimiter) {
                Cell cell = queue.poll();
                tick = pollute(matrix, queue, cell, -1, 0) || tick;
                tick = pollute(matrix, queue, cell, 1, 0) || tick;
                tick = pollute(matrix, queue, cell, 0, -1) || tick;
                tick = pollute(matrix, queue, cell, 0, 1) || tick;
            }

            // Poll the delimiter
            queue.poll();

            if (tick) {
                res++;
                tick = false;
                queue.add(new Cell(true));
            }
        }

        return res;
    }

    private static boolean pollute(int[][] matrix, Queue<Cell> queue, Cell cell, int x, int y) {
        int row = matrix.length;
        int col = matrix[0].length;

        x = cell.x + x;
        y = cell.y + y;

        if (x < 0 || x >= row || y < 0 || y >= col || matrix[x][y] != Cell.FRESH) {
            return false;
        }

        matrix[x][y] = Cell.ROTTON;
        queue.add(new Cell(x, y));

        return true;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
        int ans = rotOranges(matrix);
        if (ans == -1) {
            System.out.println("All oranges cannot rot");
        } else {
            System.out.println("Time required for all oranges to rot = " + ans);
        }
    }
}
