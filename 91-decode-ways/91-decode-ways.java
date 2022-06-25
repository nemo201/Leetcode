class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}


//memorization
// class Solution {
//     	public int numDecodings(String s) {
//         int n=s.length();
//         Integer[] mem=new Integer[n];
//         return s.length()==0?0:numDecodings(0,s,mem);      
//     }
//     private int numDecodings(int p, String s, Integer[] mem) {
//         int n=s.length();
//         if(p==n) return 1;
//         if(s.charAt(p)=='0') return 0;
//         if(mem[p]!=null) return mem[p];
//         int res=numDecodings(p+1,s,mem);
//         if(p<n-1&&(s.charAt(p)=='1'||s.charAt(p)=='2'&&s.charAt(p+1)<'7')) 
// 			res+=numDecodings(p+2,s,mem);
//         return mem[p]=res;
//     }
// }



// n2
// class Solution {
//     public int numDecodings(String s) {
//         return s.length() == 0 ? 0 : helper(0, s);
//     }
    
//     int helper(int p, String s) {
//         int n = s.length();
//         if (p == n)
//             return 1;
//         if (s.charAt(p) == '0')
//             return 0;
        
//         int res = helper(p + 1, s);
        
//         if (p < n - 1 && (s.charAt(p) == '1' || s.charAt(p)=='2' && s.charAt(p + 1) < '7'))
//             res += helper(p + 2, s);
        
//         return res;
//     }
// }


// DFS
// class Solution {
//     public int numDecodings(String s) {
//         if (s == null || s.length() == 0 || s.charAt(0) == '0')
//             return 0;
        
//         Map<String, Character> map = new HashMap<>();
//         initMap(map);
//         return dfs(s, 0, 0, map);
//     }
    
//     int dfs(String s, int result, int start, Map<String, Character> map) {
//         if (start >= s.length())
//             return result + 1;
        
//         //using first character
//         if (start + 1 <= s.length() && map.containsKey(s.substring(start, start + 1)))
//             result = dfs(s, result, start + 1, map);
        
//         //using second character
//         if (start + 2 <= s.length() && map.containsKey(s.substring(start, start + 2)))
//             result = dfs(s, result, start + 2, map);
        
//         return result;
//     }
    
//     private void initMap(Map<String, Character> codes){
//         for(int i = 1; i <= 26; i++){
//             char c = (char) ((int)'A' + (i - 1));
//             codes.put(String.valueOf(i), c);
//         }
//     }
// }