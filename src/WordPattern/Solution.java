package WordPattern;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();

        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");

        if (patterns.length != strs.length)
            return false;

        for (int i = 0; i < strs.length; i++) {
            char p = patterns[i];
            String s = strs[i];

            if (m1.containsKey(p)) {
                // Has pattern but not match
                if (!m1.get(p).equals(s))
                    return false;
                continue; // Has pattern and matched
            }

            // Does not have pattern; but str is held by other pattern
            if (m2.containsKey(s))
                return false;

            // Register the pattern
            m1.put(p, s);
            m2.put(s, p);
        }

        return true;
    }
}
