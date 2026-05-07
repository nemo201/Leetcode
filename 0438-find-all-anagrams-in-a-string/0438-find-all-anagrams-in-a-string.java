class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) {
            return ans;
        }

        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }
        
        for (int i = 0; i < m; i++) {
            window[s.charAt(i) - 'a']++;

            if (i >= n) {
                window[s.charAt(i - n) - 'a']--;
            }

            if (Arrays.equals(need, window)) {
                ans.add(i - n + 1);
            }
        }
        return ans;
    }
}