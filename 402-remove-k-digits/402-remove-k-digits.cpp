class Solution {
public:
    string removeKdigits(string num, int k) {
        int len = num.size();
        if (len == k)
            return "0";
        
        stack<char> stack;
        int i = 0;
        while (i < len) {
            while (k > 0 && !stack.empty() && stack.top() > num[i]) {
                stack.pop();
                k--;
            }
            stack.push(num[i]);
            i++;
        }
        while(k > 0) {
            stack.pop();
            k--;
        }
        string ans;
        while (!stack.empty()) {
            ans += stack.top();
            stack.pop();
        }
        while (ans.size() > 1 && ans.back() == '0')
            ans.pop_back();
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};