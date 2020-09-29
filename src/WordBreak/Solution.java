package WordBreak;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] opt = new boolean[s.length() + 1];
        opt[0] = true; // Substring(0, 0) is "" and shoud return true

        for (int i = 1; i < opt.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (opt[j] && wordDict.contains(s.substring(j, i))) {
                    opt[i] = true;
                    break;
                }
            }
        }

        return opt[s.length()];
    }
}
