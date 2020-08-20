package GoatLatin;

class Solution {
    public String toGoatLatin(String S) {
        String[] tokens = S.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            char firstChar = token.charAt(0);

            if (isVowel(firstChar)) {
                sb.append(token);
            } else {
                sb.append(token.substring(1));
                sb.append(firstChar);
            }

            sb.append("ma");

            for (int j = 0; j < i + 1; j++) {
                sb.append('a');
            }

            if (i != tokens.length - 1) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
                || c == 'U';
    }
}
