class Solution {
    public int countVowelStrings(int n) {
        return helper(n, 1);
    }
    
    private int helper(int n, int vowels) {
        if (n == 0)
            return 1;
        int result = 0;
        for (int i = vowels; i <= 5; i++) {
            result += helper(n - 1, i);
        }
        return result;
    }
}