class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char, int>> stk;
        stk.push({'#', 0});
        for (int i = 0; i < size(s); i++) {
            stk.push({s[i], stk.top().first == s[i] ? stk.top().second + 1 : 1});
            if (stk.top().second == k) {
                while(stk.top().first == s[i]) stk.pop();
                s.erase(i - k + 1, k);
                i -= k;
            }
        }
        return s;
    }
};