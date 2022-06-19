class Solution {
    static String[] keypad = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if (digits.length() == 0)
            return list;
        
        dfs(sb, 0, digits, keypad, list);
        return list;
    }
    
    public void dfs(StringBuilder sb, int index, String digits, String[] keypad, List<String> ans) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        
        String option = keypad[digits.charAt(index) - '0'];
        for (char opt : option.toCharArray()) {
            sb.append(opt);
            dfs(sb, index + 1, digits, keypad, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}