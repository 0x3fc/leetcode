package NQueens;

import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        if (n == 0) {
            return res;
        }

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(res, board, 0);

        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            res.add(makeRes(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(res, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private List<String> makeRes(char[][] board) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }

        return res;
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
