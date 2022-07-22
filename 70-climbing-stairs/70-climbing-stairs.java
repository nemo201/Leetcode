class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        
        if (!memo.containsKey(n))
            memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        
        return memo.get(n);
    }
}

// recurssion
// class Solution {
//     public int climbStairs(int n) {
//         if (n <= 2)
//             return n;
//         return climbStairs(n - 1) + climbStairs(n - 2);
//     }
// }