package ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;

        while (i < j) {
            int h = Math.min(height[i], height[j]);

            max = Math.max(max, (j - i) * h);

            while (i < j && height[i] <= h) {
                i++;
            }
            while (i < j && height[j] <= h) {
                j--;
            }
        }

        return max;
    }
}
