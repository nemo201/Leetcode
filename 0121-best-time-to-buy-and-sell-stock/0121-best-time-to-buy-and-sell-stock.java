class Solution {
    public int maxProfit(int[] prices) {
        // int max = 0;
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

        //BF        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (prices[i] - prices[j] > max) {
        //             max = prices[i] - prices[j];
        //         }
        //     }
        // }
        // return max;

        //Recursive
        // return helper (0, 0, Integer.MAX_VALUE, prices);


    }

    // private int helper (int index, int maxProfit, int minPrice, int[] prices) {
    //     if (index == prices.length) {
    //         return maxProfit;
    //     }

    //     minPrice = Math.min(minPrice, prices[index]);
    //     maxProfit = Math.max(maxProfit, prices[index] - minPrice);

    //     return helper (index + 1, maxProfit, minPrice, prices);
    // }
}