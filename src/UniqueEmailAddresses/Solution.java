package UniqueEmailAddresses;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            StringBuilder e = new StringBuilder();
            boolean encounteredPlus = false;

            for (int i = 0; i < email.length(); i++) {
                char c = Character.toLowerCase(email.charAt(i));

                if (c == '@') {
                    e.append(email.substring(i).toLowerCase());
                    break;
                }

                if (c == '.') {
                    continue;
                }

                if (c == '+') {
                    encounteredPlus = true;
                }

                if (!encounteredPlus) {
                    e.append(c);
                }
            }

            unique.add(e.toString());
        }

        return unique.size();
    }
}
