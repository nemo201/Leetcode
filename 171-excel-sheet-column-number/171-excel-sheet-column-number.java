class Solution {
    public int titleToNumber(String s) {
        if (s == null)
            return -1;
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            res = res * 26;
            res += s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}