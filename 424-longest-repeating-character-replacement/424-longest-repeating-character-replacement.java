class Solution {
    public int characterReplacement(String s, int k) {
        int []freq = new int[26];
        int mostFreq = 0;
        int left = 0, max = 0;
        
        for (int right = 0; right < s.length(); right++) {
            freq [s.charAt(right) - 'A']++;
            mostFreq = Math.max(mostFreq, freq[s.charAt(right) - 'A']);
            
            int ltc = right - left + 1 - mostFreq;
            if (ltc > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}