class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        
        int[] freq = new int[26];
        
        for (String word : words2) {
            int[] temp = new int[26];
            for (char c : word.toCharArray())
                temp[c - 'a']++;
            
            for (int i = 0; i < 26; i++)
                freq[i] = Math.max(freq[i], temp[i]);
        }
        
        for (String word : words1) {
            int[] compare = new int[26];
            
            for (char c : word.toCharArray())
                compare[c - 'a']++;
            
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    if (freq[i] > compare[i]){
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                ans.add(word);
        }
        return ans;
    }
}