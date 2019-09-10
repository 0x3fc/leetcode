package TrappingRainWater;

class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int total = 0;

        int left = 0;
        int right = length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                total += leftMax - height[left];
                left++;
            } else {
                total += rightMax - height[right];
                right--;
            }
        }

        return total;
    }
}
