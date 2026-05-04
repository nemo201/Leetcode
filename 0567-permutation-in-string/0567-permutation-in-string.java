class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] count = new int[26];

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, required = s1.length();

        while (right < s2.length()) {
            if (count[s2.charAt(right) - 'a'] > 0) {
                required--;
            }
            count[s2.charAt(right) - 'a']--;

            right++;
            if (required == 0) {
                return true;
            }

            if (right - left == s1.length()) {
                if (count[s2.charAt(left) - 'a'] >= 0) {
                    required++;
                }
                count[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }
}