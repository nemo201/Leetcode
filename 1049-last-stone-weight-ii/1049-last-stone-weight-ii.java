class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;

        for (int stone : stones) {
            total += stone;
        }

        int target = total / 2;
        Integer[][] memo = new Integer[stones.length][target + 1];
        int best = helper (stones, 0, target, memo);

        return total - 2 * best;
    }

    private int helper (int[] stones, int i, int target, Integer[][] memo) {
        if (i == stones.length || target == 0) {
            return 0;
        }

        if (memo[i][target] != null) {
            return memo[i][target];
        }

        int skip = helper (stones, i + 1, target, memo);
        int take = 0;

        if (stones[i] <= target) {
            take = stones[i] + helper(stones, i + 1, target - stones[i], memo);
        }

        return memo[i][target] = Math.max(take, skip);
    }
}