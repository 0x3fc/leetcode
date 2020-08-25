package MinimumCostForTickets;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] opt = new int[days.length + 1];

        for (int i = 0; i < days.length; i++) {
            int oneDayPass = opt[i] + costs[0];

            int j = 0;
            for (; j < days.length && days[j] <= days[i] - 7; j++)
                ;
            int sevenDayPass = opt[j] + costs[1];

            int k = 0;
            for (; k < days.length && days[k] <= days[i] - 30; k++)
                ;
            int thirtyDayPass = opt[k] + costs[2];

            opt[i + 1] = Math.min(Math.min(oneDayPass, sevenDayPass), thirtyDayPass);
        }

        return opt[days.length];
    }
}
