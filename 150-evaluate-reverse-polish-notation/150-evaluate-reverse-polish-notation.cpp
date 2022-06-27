class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        return evaluatePostFix(tokens);
    }
    
    int applyOp(int a, int b, string op){ 
        switch(op[0]){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
    
    int evaluatePostFix(vector<string>& tokens){
        stack<int> values;
        for (int i = 0; i < tokens.size(); i++) {
            if ((tokens[i] == "+" || tokens[i] == "*" || tokens[i] == "-" || tokens[i] == "/")) {
                int var1 = values.top();
                values.pop();
                
                int var2 = values.top();
                values.pop();
                
                int val = applyOp(var2, var1, tokens[i]);
                values.push(val);
            } else {
                values.push(stoi(tokens[i]));
            }
        }
        return values.top(); 
    }
};