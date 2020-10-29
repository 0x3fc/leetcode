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

    public int maxDistToClosestTwoPointer(int[] seats) {
        int i = 0;
        int j = seats.length - 1;

        while (seats[i] == 0)
            i++;
        while (seats[j] == 0)
            j--;
        int max = Math.max(i, seats.length - j - 1);

        while (i < j) {
            int empty = 0;
            while (i < j && seats[i] == 1)
                i++;
            while (i < j && seats[i] == 0) {
                i++;
                empty++;
            }
            max = Math.max(max, (empty + 1) / 2);
        }

        return max;
    }
}
