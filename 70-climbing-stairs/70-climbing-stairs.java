class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// memo
// class Solution {
//     Map<Integer, Integer> memo = new HashMap<>();
//     public int climbStairs(int n) {
//         if (n <= 2)
//             return n;
        
//         if (!memo.containsKey(n))
//             memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        
//         return memo.get(n);
//     }
// }

// recurssion
// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2)
//             return n;
//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
// }