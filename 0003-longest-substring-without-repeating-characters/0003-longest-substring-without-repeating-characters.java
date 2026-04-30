class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastseen = new int[128];
        Arrays.fill(lastseen, -1);

        int p1 = 0;
        int max = 0;

        for (int p2 = 0; p2 < s.length(); p2++) {
            char c = s.charAt(p2);

            if (lastseen[c] >= p1) {
                p1 = lastseen[c] + 1;
            }

            lastseen[c] = p2;
            max = Math.max(max, p2 - p1 + 1);
        }
        return max;
    }
}