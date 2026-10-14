class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
                cookie++;
            } else {
                cookie++;
            }
        }
        return child;
    }
}