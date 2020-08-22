package RandomPointInNonOverlappingRectangles;

import java.util.Random;
import java.util.TreeMap;

class Solution {
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private int[][] rects;
    private Random random = new Random();
    private int area = 0;

    public Solution(int[][] rects) {
        this.rects = rects;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            area += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(area, i);
        }
    }

    public int[] pick() {
        int key = map.get(map.higherKey(random.nextInt(area)));
        int[] rect = rects[key];
        int left = rect[0], right = rect[2], bot = rect[1], top = rect[3];
        return new int[] { left + random.nextInt(right - left + 1), bot + random.nextInt(top - bot + 1) };
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(rects); int[] param_1 = obj.pick();
 */
