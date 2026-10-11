class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int max = Integer.MIN_VALUE;
        int curMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            }

            max = Math.max(max, prices[i] - curMin);
        }
        return max;
    }
}