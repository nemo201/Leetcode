class Solution {
    public boolean wordBreak(String s, List<String> wordList) {
        boolean[] T = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordList);
        
        T[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(T[j] && set.contains(s.substring(j, i))) {
                    T[i] = true;
                    break;
                }
            }
        }
        return T[s.length()];
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