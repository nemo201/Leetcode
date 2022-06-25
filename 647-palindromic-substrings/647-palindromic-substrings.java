class Solution {
    int count = 1;
    public int countSubstrings(String s) {
        
        if (s.length () == 0)
            return 0;
        
        for (int i = 0; i < s.length() - 1; i++) {
            checkPal(s, i, i);
            checkPal(s, i, i + 1);
        }
        return count;
    }
    
    void checkPal(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            count++;
            L--;
            R++;
        }
    }
}