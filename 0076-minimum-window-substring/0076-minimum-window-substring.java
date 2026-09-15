class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = 0;

        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) {
                required++;
            }
        }

        int formed = 0;
        int left = 0, right = 0, start = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (need[c] > 0 && window[c] == need[c]) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
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
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}