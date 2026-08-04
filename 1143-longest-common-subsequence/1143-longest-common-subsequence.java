class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] memo = new Integer[text1.length()][text2.length()];
        return helper(text1, text2, 0, 0, memo);
    }

    private int helper(String t1, String t2, int i, int j, Integer[][] memo) {
        if (i >= t1.length() || j >= t2.length()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (t1.charAt(i) == t2.charAt(j)) {
            return 1 + helper(t1, t2, i + 1, j + 1, memo);
        }

        int taket1 = helper(t1, t2, i, j + 1, memo);
        int taket2 = helper(t1, t2, i + 1, j, memo);

        return memo[i][j] = Math.max(taket1, taket2);
    }
}