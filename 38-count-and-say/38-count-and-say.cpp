class Solution {
public:
    string countAndSay(int n) {
        string s = "1";
        for (int i = 1; i < n; i++) {
            s = countIndex(s);
        }
        return s;
    }
    
    string countIndex(string s) {
        string res;
        char c = s[0];
        int count = 1;
        for (int i = 1; i < s.size(); i++) {
            if (c == s[i])
                count++;
            else {
                res += to_string(count);
                res += c;
                c = s[i];
                count = 1;
            }
        }
        res += to_string(count);
        res += c;
        return res;
    }
};