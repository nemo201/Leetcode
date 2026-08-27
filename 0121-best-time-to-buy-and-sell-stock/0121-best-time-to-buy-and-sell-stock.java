class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int noStock = 0;
        int holding = -prices[0];

        for (int i = 1; i < n; i++) {
            noStock = Math.max(noStock, holding + prices[i]);
            holding = Math.max(holding, -prices[i]);
        }

        return noStock;
    }
}