class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int max = 1;
        
        for (int j = 1; j < nums.length; j++) {
            int i = 0;
            while (i < j) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(1 + dp[i], dp[j]);
                }
                i++;
            }
            max = Math.max(max, dp[j]);
        }
        return max;
    }
}