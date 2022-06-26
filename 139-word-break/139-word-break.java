class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    
    boolean helper(String s, Set<String> set) {
        if (s == null || s.length() == 0)
            return false;
        
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                
                if (set.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}

// bruteforce
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> set = new HashSet<>(wordDict);
//         return helper(s, set);
//     }
    
//     boolean helper(String s, Set<String> set) {
//         int len = s.length();
//         if (len == 0)
//             return true;
        
//         for (int i = 1; i <= len; i++) {
//             if (set.contains(s.substring(0, i)) && helper(s.substring(i), set))
//                 return true;
//         }
//         return false;
//     }
// }