package FruitIntoBaskets;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] tree) {
        int max = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for (int i = 0, j = 0; j < tree.length; max = Math.max(max, j - i + 1), j++) {
            basket.put(tree[j], j);

            if (basket.size() > 2) {
                int minIndex = Collections.min(basket.values());
                basket.remove(tree[minIndex]);
                i = minIndex + 1;
            }
        }

        return max;
    }
}
