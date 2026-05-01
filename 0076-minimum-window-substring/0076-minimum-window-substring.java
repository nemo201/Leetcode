class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) return "";

        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) required++;
        }

        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE, start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;

            if (need[c] > 0 && window[c] == need[c]) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left);
                window[lc]--;

                if (need[lc] > 0 && window[lc] < need[lc]) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}