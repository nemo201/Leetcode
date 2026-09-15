class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int k = s1.length();
        for (int i = 0; i < k; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(need, window)) {
            return true;
        }

        for (int right = k; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;
            int left = right - k;
            window[s2.charAt(left) - 'a']--;

            if (Arrays.equals(need, window)) {
                return true;
            }
        }
        return false;
    }
}