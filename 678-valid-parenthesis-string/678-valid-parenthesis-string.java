class Solution {
    public boolean checkValidString(String s) {
        
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            left += c == '(' ? 1 : -1;
            right += c != ')' ? 1 : -1;
            
            if (right < 0)
                break;
            left = Math.max(left, 0);
        }
        return left == 0;
    }
}