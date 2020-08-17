package DistributeCandiesToPeople;

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            res[give % num_people] += Math.min(candies, ++give);
        }
        return res;
    }
}
