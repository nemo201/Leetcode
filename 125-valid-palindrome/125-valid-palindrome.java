public class Solution {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reverse = new StringBuffer(actual).reverse().toString();
        return actual.equals(reverse);
    }
}