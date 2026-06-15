class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n =s.length();
        int[] memo = new int[n];
        return n == 0 ? 0 : helper(0, s, memo);
    }

    private int helper (int i, String s, int[] memo) {
        int n = s.length();
        if (i == n) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }

        int res = helper(i + 1, s, memo);
        if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += helper (i + 2, s, memo);
        }
        return memo[i] = res;
    }
}