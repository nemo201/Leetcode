class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        int p1 = 0;
        int max = 0;

        for (int p2 = 0; p2 < n; p2++) {
            char c = s.charAt(p2);

            if (lastSeen[c] >= p1) {
                p1 = lastSeen[c] + 1;
            }

            lastSeen[c] = p2;
            max = Math.max(max, p2 - p1 + 1);
        }

        return max;
    }
}