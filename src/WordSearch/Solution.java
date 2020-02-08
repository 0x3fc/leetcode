package WordSearch;

class Solution {
    private int M;
    private int N;
    private boolean[][] visited;
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        M = board.length;
        if (M < 1) return false;
        N = board[0].length;
        if (N < 1) return false;

        visited = new boolean[M][N];
        this.board = board;
        this.word = word;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (exist(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int index, int i, int j) {
        if (index == word.length() - 1) return board[i][j] == word.charAt(index);
        if (board[i][j] != word.charAt(index)) return false;

        visited[i][j] = true;

        if (i > 0 && !visited[i - 1][j] && exist(index + 1, i - 1, j)) return true;
        if (i < M - 1 && !visited[i + 1][j] && exist(index + 1, i + 1, j)) return true;
        if (j > 0 && !visited[i][j - 1] && exist(index + 1, i, j - 1)) return true;
        if (j < N - 1 && !visited[i][j + 1] && exist(index + 1, i, j + 1)) return true;

        visited[i][j] = false;

        return false;
    }
}
