class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] memo = new Integer[amount + 1][coins.length];
        int ans = helper (coins, amount, coins.length - 1, memo);
        return ans >= 1_000_000 ? -1 : ans;
    }

    private int helper (int[] coins, int target, int i, Integer[][] memo) {
        if (target == 0) {
            return 0;
        }

        if (i < 0) {
            return 1_000_000;
        }

        if (memo[target][i] != null) {
            return memo[target][i];
        }

        int take = 1_000_000;
        if (target >= coins[i]) {
            take = 1 + helper (coins, target - coins[i], i, memo);
        }

        int skip = helper (coins, target, i - 1, memo);

        return memo[target][i] = Math.min(take, skip);
    }
}