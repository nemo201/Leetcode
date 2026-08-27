class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int  transaction = 1; transaction <= k; transaction++) {
                buy[transaction] = Math.max(buy[transaction], sell[transaction - 1] - price);
                sell[transaction] = Math.max(sell[transaction], buy[transaction] + price);
            }
        }

        return sell[k];
    }
}