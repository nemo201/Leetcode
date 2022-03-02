class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;
        if (s.length() > t.length())
            return false;
        int start = 0, end = 0;
        
        while (end < t.length()) {
            if (t.charAt(end) == s.charAt(start)) {
                start++;
                if (start == s.length())
                    return true;
            }
            end++;
        }
        return false;
    }
}