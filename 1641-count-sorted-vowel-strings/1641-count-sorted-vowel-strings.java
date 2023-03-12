class Solution {
    public int countVowelStrings(int n) {
        return helper(n, 5);
    }
    
    private int helper(int n, int vowels) {
        if (n == 1)
            return vowels;
        if (vowels == 1)
            return 1;
        return helper(n - 1, vowels) + helper(n , vowels - 1);
    }
}