class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        int N = pushed.size();
        stack<int> stk;
        
        int j = 0;
        for (int x : pushed) {
            stk.push(x);
            while (!stk.empty() && j < N && stk.top() == popped[j]) {
                stk.pop();
                j++;
            }
        }
        return j == N;
    }
};