class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n);
            for (int[] f : flights) {
                int cur = f[0];
                int next = f[1];
                int price = f[2];
                
                if (cost[cur] == Integer.MAX_VALUE)
                    continue;
                temp[next] = Math.min(temp[next], cost[cur] + price);
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}