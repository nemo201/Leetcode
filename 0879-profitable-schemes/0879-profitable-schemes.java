class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1;

        for (int i = 0; i < group.length; i++) {
            int g = group[i];
            int p = profit[i];

            for (int people = n; people >= g; people--) {
                for (int  cur = minProfit; cur >= 0; cur--) {
                    int newProfit = Math.min(minProfit, cur + p);
                    dp[people][newProfit] = (dp[people][newProfit] + dp[people - g][cur]) % MOD;
                }
            }
        }

        int ans = 0;
        for (int people = 0; people <= n; people++) {
            ans = (ans + dp[people][minProfit]) % MOD;
        }

        return ans;
    }
}