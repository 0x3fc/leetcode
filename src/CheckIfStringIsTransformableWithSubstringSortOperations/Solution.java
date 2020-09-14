package CheckIfStringIsTransformableWithSubstringSortOperations;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isTransformable(String s, String t) {
        Queue<Integer>[] indices = new LinkedList[10];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = new LinkedList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            indices[s.charAt(i) - '0'].offer(i);
        }

        for (int i = 0; i < t.length(); i++) {
            int num = t.charAt(i) - '0';

            // We don't have enough num to transform
            if (indices[num].isEmpty())
                return false;

            int idx = indices[num].peek();
            for (int j = 0; j < num; j++) {
                // If there is a smaller num before the current index,
                // We are not able to sort the current n to the desired place
                if (!indices[j].isEmpty() && indices[j].peek() < idx)
                    return false;
            }

            indices[num].poll();
        }

        return true;
    }
}
