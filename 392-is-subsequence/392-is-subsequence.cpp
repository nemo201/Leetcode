class Solution {
public:
    bool isSubsequence(string s, string t) {
        if (s.size() == 0)
            return true;
        if (s.size() > t.size())
            return false;
        int start = 0, end = 0;
        while (end < t.size()) {
            if (t[end] == s[start]) {
                start++;
                if (start == s.size())
                    return true;
            }
            end++;
        }
        return false;
    }
};