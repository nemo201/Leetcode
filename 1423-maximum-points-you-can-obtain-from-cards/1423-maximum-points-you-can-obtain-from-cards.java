class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, lSum = 0;
        for(int i = 0; i < k; ++i){
            lSum += cardPoints[i];
        }
        int max = lSum;
        for(int rSum = 0, i = 0; i < k; ++i){
            rSum += cardPoints[n-1-i];
            lSum -= cardPoints[k-1-i];
            max = Math.max(max,lSum+rSum);
        }
        return max;
    }
}