class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > ransomNote.length())
            return false;
        
        int []freq = new int[26];
        
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            freq[c - 'a']--;
        }
        
        for (int n : freq) {
            if (n < 0)
                return false;
        }
        
        return true;
    }
}