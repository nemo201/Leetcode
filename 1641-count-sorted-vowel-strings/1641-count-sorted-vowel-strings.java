class Solution {
    public int countVowelStrings(int n) {
        int[][] memo = new int[n + 1][6];
        return helper(n, 5, memo);
    }
    
    private int helper(int n, int vowels, int[][] memo) {
        if (n == 1)
            return vowels;
        if (vowels == 1)
            return 1;
        if (memo[n][vowels] != 0)
            return memo[n][vowels];
        int res = helper(n - 1, vowels, memo) + helper(n , vowels - 1, memo);
        
        memo[n][vowels] = res;
        return res;
    }
}