class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][6];
        
        for (int i = 0; i <= 5; i++)
            dp[1][i] = i;
        
        for (int j = 2; j <= n; j++) {
            dp[j][1] = 1;
            for (int i = 2; i <= 5; i++) {
                dp[j][i] = dp[j][i - 1] + dp[j - 1][i];
            }
        }
        return dp[n][5];
    }
}