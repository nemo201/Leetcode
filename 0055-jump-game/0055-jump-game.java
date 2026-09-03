class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        boolean[] dp = new boolean[n];
        dp[0] = true;

        for (int i = 0; i < n; i++) {

            if (!dp[i]) {
                continue;
            }

            for (int j = i + 1;
                 j <= i + nums[i] && j < n;
                 j++) {

                dp[j] = true;
            }
        }

        return dp[n - 1];
    }
}