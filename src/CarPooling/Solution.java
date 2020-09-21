package CarPooling;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        final int MAX_LOCATION = 1001;
        int[] start = new int[MAX_LOCATION];
        int[] end = new int[MAX_LOCATION];

        int minLocation = Integer.MAX_VALUE;
        int maxLocation = Integer.MIN_VALUE;

        for (int[] trip : trips) {
            start[trip[1]] += trip[0];
            end[trip[2]] += trip[0];

            minLocation = Math.min(minLocation, trip[1]);
            maxLocation = Math.max(maxLocation, trip[2]);
        }

        int inCar = 0;
        for (int i = minLocation; i <= maxLocation; i++) {
            inCar += start[i] - end[i];
            if (inCar > capacity)
                return false;
        }

        return true;
    }

    public boolean carPoolingBySort(int[][] trips, int capacity) {
        List<int[]> orders = new ArrayList<>(); // [location, capacity change]
        for (int[] trip : trips) {
            orders.add(new int[] { trip[1], trip[0] });
            orders.add(new int[] { trip[2], -trip[0] });
        }

        orders.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int[] order : orders) {
            capacity -= order[1];
            if (capacity < 0)
                return false;
        }
        
        return true;
    }
}
