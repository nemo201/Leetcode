class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                depth++;
            else
                depth--;
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(')
                score += Math.pow(2, depth);
        }
        return score;
    }
}

// class Solution {
//     public int scoreOfParentheses(String s) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(0);
        
//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 stack.push(0);
//             } else {
//                 int v = stack.pop();
//                 int w = stack.pop();
//                 stack.push(w + Math.max(2* v, 1));
//             }
//         }
//         return stack.pop();
//     }
// }