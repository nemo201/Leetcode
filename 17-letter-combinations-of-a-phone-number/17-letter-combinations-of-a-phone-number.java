class Solution {
    
    static String[] keypad = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList();
        
        if (digits.length() == 0)
            return res;
        
        dfs (sb, 0, digits, keypad, res);
        
        return res;
    }
    
    private void dfs(StringBuilder sb, int index, String digits, String[] keypad, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        String options = keypad[digits.charAt(index) - '0'];
        for (char option : options.toCharArray()) {
            sb.append(option);
            dfs(sb, index + 1, digits, keypad, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}