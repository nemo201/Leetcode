class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = cost.clone();
            for (int[] f : flights) {
                int from = f[0];
                int to = f[1];
                int price = f[2];

                if (cost[from] == Integer.MAX_VALUE) {
                    continue;
                }

                temp[to] = Math.min(temp[to], cost[from] + price);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}