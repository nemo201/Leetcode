class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                stack.add(i);
            if (sb.charAt(i) == ')') {
                if(!stack.empty())
                    stack.pop();
                else
                    sb.setCharAt(i, '*');
            }
        }
        while (!stack.empty())
            sb.setCharAt(stack.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }
}