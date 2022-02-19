class Solution {
    public boolean isAnagram(String s, String t) {
        int[] al = new int[26];
        for (char c : s.toCharArray()) {
            al[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            al[c - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (al[i] != 0)
                return false;
        }
        return true;
    }
}