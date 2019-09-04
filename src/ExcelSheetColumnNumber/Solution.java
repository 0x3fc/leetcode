package ExcelSheetColumnNumber;

class Solution {
    public int titleToNumber(String s) {
        int base = 1;
        int sum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * base;

            base *= 26;
        }

        return sum;
    }
}
