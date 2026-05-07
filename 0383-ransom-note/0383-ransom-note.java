class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length(), n = magazine.length();

        if (m > n) {
            return false;
        }

        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int count : freq) {
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}