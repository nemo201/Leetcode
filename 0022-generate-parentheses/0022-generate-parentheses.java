class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        helper(new StringBuilder(), 0, 0, ans, n);
        return ans;
    }
    
    private void helper(StringBuilder cur, int open, int closed, List<String> ans, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        
        if (open < max) {
            cur.append("(");
            helper(cur, open + 1, closed, ans, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        
        if (closed < open) {
            cur.append(")");
            helper(cur, open, closed + 1, ans, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}