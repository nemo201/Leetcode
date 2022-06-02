class Solution {
    public int maxProfit(int[] p) {
        int maxSoFar = 0, maxCur = 0;
        for (int i = 1; i < p.length; i++) {
            maxCur = Math.max(0, maxCur += p[i] - p[i - 1]);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }
        return maxSoFar;
    }
}