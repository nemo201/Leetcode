class Solution {
public:
    int scoreOfParentheses(string s) {
        int score = 0, depth = 0;
        
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(')
                depth++;
            else
                depth--;
            if (s[i] == ')'&& s[i - 1] == '(')
                score += pow(2, depth);
        }
        return score;
    }
};

// class Solution {
// public:
//     int scoreOfParentheses(string s) {
//         stack<int> stk;
//         stk.push(0);
        
//         for (int i = 0; i < s.size(); i++) {
//             if (s[i] == '(') {
//                 stk.push(0);
//             } else {
//                 int v = stk.top();
//                 stk.pop();
//                 int w = stk.top();
//                 stk.pop();
//                 stk.push(w + max(2 * v, 1));
//             }
//         }
//         return stk.top();
//     }
// };