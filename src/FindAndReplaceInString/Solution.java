package FindAndReplaceInString;

import java.util.*;

class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int len = S.length();
        int[] buckets = new int[len];

        Arrays.fill(buckets, -1);

        for (int i = 0; i < indexes.length; i++) {
            buckets[indexes[i]] = i;
        }

        StringBuilder sb = new StringBuilder(S);

        for (int i = len - 1; i >= 0; i--) {
            int bucket = buckets[i];

            if (bucket == -1) {
                continue;
            }

            int index = indexes[bucket];
            String source = sources[bucket];

            if (sb.substring(index).startsWith(source)) {
                String target = targets[bucket];
                sb.replace(index, index + source.length(), target);
            }
        }

        return sb.toString();
    }
}
