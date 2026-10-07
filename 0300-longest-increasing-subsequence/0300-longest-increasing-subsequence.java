class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length + 1];
        return helper(0, -1, nums, memo);
    }

    private int helper(int i, int prev, int[] nums, Integer[][] memo) {
        if (i == nums.length) {
            return 0;
        }

        if (memo[i][prev + 1] != null) {
            return memo[i][prev + 1];
        }

        int skip = helper(i + 1, prev, nums, memo);
        int take = 0;
        if (prev == - 1 || nums[i] > nums[prev]) {
            take = 1 + helper(i + 1, i, nums, memo);
        }
        return memo[i][prev + 1] = Math.max(take, skip);
    }
}