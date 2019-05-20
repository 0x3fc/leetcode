package RectangleOverlap;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int r1BottomLeftX = rec1[0];
        int r1BottomLeftY = rec1[1];
        int r1TopRightX = rec1[2];
        int r1TopRightY = rec1[3];

        int r2BottomLeftX = rec2[0];
        int r2BottomLeftY = rec2[1];
        int r2TopRightX = rec2[2];
        int r2TopRightY = rec2[3];

        return !(r1BottomLeftY >= r2TopRightY || // r1 above r2
                r1TopRightY <= r2BottomLeftY || // r1 below r2
                r1BottomLeftX >= r2TopRightX || // r1 at right of r2
                r1TopRightX <= r2BottomLeftX // r1 at left of r2
        );
    }
}
