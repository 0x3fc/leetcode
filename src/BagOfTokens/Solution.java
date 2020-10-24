package BagOfTokens;

import java.util.Arrays;

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);

        int max = 0;
        int score = 0;
        int i = 0, j = tokens.length - 1;

        while (i <= j) {
            if (P >= tokens[i]) {
                P -= tokens[i++];
                score++;
                max = Math.max(max, score);
            } else if (score > 0) {
                P += tokens[j--];
                score--;
            } else {
                break;
            }
        }

        return max;
    }
}
