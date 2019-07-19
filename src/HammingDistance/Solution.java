package HammingDistance;

class Solution {
    public int hammingDistance(int x, int y) {
        int dist = x ^ y;
        int count = 0;

        while (dist != 0) {
            // count += dist & 1;
            // dist >>>= 1;

            dist &= (dist - 1);
            count++;
        }

        return count;
    }
}
