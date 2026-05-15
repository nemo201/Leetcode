class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}