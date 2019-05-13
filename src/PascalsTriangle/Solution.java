package PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        if (numRows <= 0) {
            return res;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> previousRow = res.get(i - 1);
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(previousRow.get(j - 1) + previousRow.get(j));
                }
            }

            res.add(row);
        }

        return res;
    }
}
