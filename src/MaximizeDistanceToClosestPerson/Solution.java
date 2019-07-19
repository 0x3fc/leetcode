package MaximizeDistanceToClosestPerson;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int count = 0;
        int max = 0;

        boolean first = true;

        for (int seat : seats) {
            if (seat == 1) {
                if (first) {
                    max = count;
                    first = false;
                } else {
                    max = Math.max((count + 1) / 2, max);
                }
                count = 0;
            } else {
                count++;
            }
        }

        return Math.max(count, max);
    }
}
