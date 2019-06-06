package GenerateParentheses;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(res, "", 0, 0, n);

        return res;
    }

    private void backtrack(List<String> res, String comb, int open, int close, int n) {
        if (comb.length() == n * 2) {
            res.add(comb);
            return;
        }

        if (open < n) {
            backtrack(res, comb + "(", open + 1, close, n);
        }

        if (close < open) {
            backtrack(res, comb + ")", open, close + 1, n);
        }
    }
}
