package RangeSumQueryImmutable;

class NumArray {
    private int[] cache;

    public NumArray(int[] nums) {
        cache = new int[nums.length + 1];
        cache[0] = 0;
        for (int i = 1; i < cache.length; i++) {
            cache[i] = cache[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return cache[j + 1] - cache[i];
    }
}
