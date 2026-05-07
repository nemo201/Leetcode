class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();
        List<Integer> ans = new ArrayList<>();
        if (m < n) {
            return ans;
        }

        int[] freq = new int[26];
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        String key = helper(freq);

        for (int i = 0; i <= m - n; i++) {
            int[] curFreq = new int[26];
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                curFreq[c - 'a']++;
            }

            String curKey = helper(curFreq);

            if (curKey.equals(key)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private String helper(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (int count : freq) {
            sb.append(count).append("#");
        }

        String key = sb.toString();
        return key;
    }
}