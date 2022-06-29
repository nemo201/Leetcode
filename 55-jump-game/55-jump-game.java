class Solution {
    int[] dp;
    public boolean canJump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(0, nums) == 1;
    }
    private int helper(int i , int[] nums){
        if(i == nums.length-1){
                return 1;
        }
        if(dp[i] != -1) return dp[i];
        for(int k = 1; k <= nums[i];k++){
            if(helper(i+k,nums) == 1) return dp[i] = 1;
        }
        return dp[i] = 0 ;
    }
}