class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        
        for (int i = 2; i <= cost.length; i++) {
            int onestep = dp[i - 1] + cost[i - 1];
            int twostep = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(onestep, twostep);
        }
        //we have to go out of bounds
        return dp[cost.length];
    }
}

// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int one = 0, two = 0;
        
//         for (int i = 2; i < cost.length + 1; i++) {
//             int temp = one;
//             one = Math.min(one + cost[i - 1], two + cost[i - 2]);
//             two = temp;
//         }
//         return one;
//     }
// }