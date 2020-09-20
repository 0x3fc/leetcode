package SequentialDigits;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < 10; i++) {
            queue.offer(i);
        }

        while (queue.size() > 0) {
            int n = queue.poll();
            if (n > high)
                continue;
            if (n >= low)
                res.add(n);
            if (n % 10 != 9)
                queue.offer(n * 10 + n % 10 + 1);
        }

        return res;
    }

    public List<Integer> sequentialDigitsEnumerate(int low, int high) {
        int[] possibleResults = { 12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567, 678, 789, 1234, 2345, 3456,
                4567, 5678, 6789, 12345, 23456, 34567, 45678, 56789, 123456, 234567, 345678, 456789, 1234567, 2345678,
                3456789, 12345678, 23456789, 123456789 };

        List<Integer> res = new ArrayList<>();

        for (int num : possibleResults) {
            if (num >= low && num <= high)
                res.add(num);
        }

        return res;
    }
}