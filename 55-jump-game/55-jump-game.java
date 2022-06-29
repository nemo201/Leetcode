//greedy
class Solution {
    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last)
                last = i;
        }
        return last <= 0;
    }
}

// dp
// static int[] dp;
//     public boolean canJump(int[] nums) {
//         dp = new int[nums.length];
//         Arrays.fill(dp,-1);
//         return helper(0, nums) == 1;
//     }
//     private static int helper(int i , int[] nums){
//         if(i == nums.length-1){
//                 return 1;
//         }
//         if(dp[i] != -1) return dp[i];
//         for(int k = 1; k <= nums[i];k++){
//             if(helper(i+k,nums) == 1) return dp[i] = 1;
//         }
//         return dp[i] = 0 ;
//     }
// }