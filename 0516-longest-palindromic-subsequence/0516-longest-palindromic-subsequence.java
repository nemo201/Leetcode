class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];
        return helper(s, 0, n - 1, memo);
    }
    
    private int helper(String s, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];
        
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (s.charAt(i) == s.charAt(j))
            memo[i][j] = helper(s, i + 1, j - 1, memo) + 2;
        else
            memo[i][j] = Math.max(helper(s, i + 1, j, memo), helper(s, i, j - 1, memo));
        
        return memo[i][j];
    }
}