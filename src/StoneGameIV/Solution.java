package StoneGameIV;

class Solution {
    public boolean winnerSquareGameWriteForward(int n) {
        boolean[] opt = new boolean[n + 1];

        for (int i = 0; i < opt.length; i++) {
            if (opt[i])
                continue;

            for (int j = 1; i + j * j < opt.length; j++) {
                opt[i + j * j] = true;
            }
        }

        return opt[n];
    }

    public boolean winnerSquareGame(int n) {
        boolean[] opt = new boolean[n + 1];

        for (int i = 1; i < opt.length; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                if (!opt[i - j * j]) {
                    opt[i] = true;
                    break;
                }
            }
        }

        return opt[n];
    }
}
