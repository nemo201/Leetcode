class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair<Character, Integer>> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek().getKey())
                stack.push(new Pair(c, 1));
            else {
                int cnt = stack.pop().getValue() + 1;
                if (cnt != k)
                    stack.push(new Pair(c, cnt));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int cnt = stack.peek().getValue();
            char c = stack.pop().getKey();
            while (cnt-- > 0)
                sb.append(c);
        }
        return sb.reverse().toString();
    }
}