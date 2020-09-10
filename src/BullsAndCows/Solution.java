package BullsAndCows;

class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] secrets = new int[10];
        int[] guesses = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bull++;
                continue;
            }

            secrets[s - '0']++;
            guesses[g - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            cow += Math.min(secrets[i], guesses[i]);
        }

        return bull + "A" + cow + "B";
    }
}
