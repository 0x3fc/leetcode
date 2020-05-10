package ValidPerfectSquare;

class Sulution {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;

        while (start <= end) {
            long mid = start + end >>> 1;
            long sq = mid * mid;

            if (sq == num) {
                return true;
            }

            if (sq < num) {
                start = (int) mid + 1;
            } else {
                end = (int) mid - 1;
            }
        }

        return false;
    }

    public boolean newTonMethod(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
