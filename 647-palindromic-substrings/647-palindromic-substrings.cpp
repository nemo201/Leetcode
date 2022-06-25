class Solution {
public:
    int count = 1;
    int countSubstrings(string s) {
        if (s.size() == 0)
            return 0;
        
        for (int i = 0; i < s.size() - 1; i++) {
            countPal(s, i, i);
            countPal(s, i, i + 1);
        }
        return count;
    }
    
    void countPal(string s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.size() && s[L] == s[R]) {
            count++;
            L--;
            R++;
        }
    }
};