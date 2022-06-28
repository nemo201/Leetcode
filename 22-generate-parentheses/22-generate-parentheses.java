class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        bt(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    
    public void bt(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur.toString());
            return;
        }
        
        if (open < max) {
            cur.append("(");
            bt(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        
        if (close < open) {
            cur.append(")");
            bt(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}