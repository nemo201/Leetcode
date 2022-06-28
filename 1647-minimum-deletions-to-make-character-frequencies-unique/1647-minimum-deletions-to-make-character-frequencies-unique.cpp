class Solution {
public:
    int minDeletions(string s) {
        vector<int> freq(26, 0);
        for (char c : s) {
            freq[c - 'a']++;
        }
        
        sort(freq.begin(), freq.end());
        
        int maxAllowed = s.size(), deletions = 0;
        
        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            if (freq[i] > maxAllowed) {
                deletions += freq[i] - maxAllowed;
                freq[i] = maxAllowed;
            }
            maxAllowed = max(0, freq[i] - 1);
        }
        return deletions;
    }
};