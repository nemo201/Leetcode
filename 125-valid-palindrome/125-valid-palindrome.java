class Solution {
    public boolean isPalindrome(String s) {
        String a = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for(int i = 0, j = a.length() - 1; i < a.length() / 2; i++, j--) {
            if (a.charAt(i) != a.charAt(j))
                return false;
        }
        return true;
    }
}