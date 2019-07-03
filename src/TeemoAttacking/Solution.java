package TeemoAttacking;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length < 1 || duration == 0) {
            return 0;
        }

        int count = duration;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            count += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }

        return count;
    }

    public int findPoisonedDuration2(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }

        int start = 0;
        int end = 0;
        int count = 0;

        start = timeSeries[0];
        end = start + duration;

        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                count += (end - start);
                start = timeSeries[i];
                end = start + duration;
            } else {
                end = timeSeries[i] + duration;
            }
        }

        count += (end - start);

        return count;
    }
}
