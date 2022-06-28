class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        
        Arrays.sort(freq);
        
        int max = s.length(), deletions = 0;
        
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0)
                continue;
            else {
                if (freq[i] > max){
                    deletions += freq[i] - max;
                    freq[i] = max;
                }
                
                max = Math.max(0, freq[i] - 1);
            }
        }
        return deletions;
    }
}