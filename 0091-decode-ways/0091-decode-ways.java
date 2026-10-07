class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == 0) {
            return 0;
        }

        int n =s.length();
        int[] memo = new int[n];
        return n == 0 ? 0 : helper(0, s, memo);
    }

    private int helper (int index, String s, int[] memo) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] != 0) {
            return memo[index];
        }

        int result = helper (index + 1, s, memo);

        if (index < s.length() - 1 && (s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) < '7')) {
            result += helper (index + 2, s, memo);
        }

        return memo[index] = result;
    }
}