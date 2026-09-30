class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src, 0});
        int[][] cost = new int[n][k + 2];

        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int currCost = cur[0];
            int city = cur[1];
            int flightsUsed = cur[2];

            if (city == dst) {
                return currCost;
            }

            if (flightsUsed == k + 1) {
                continue;
            }

            for (int[] nei : adj.get(city)) {

                int nextCity = nei[0];
                int price = nei[1];

                int newCost = currCost + price;
                int newFlights = flightsUsed + 1;

                if (newCost < cost[nextCity][newFlights]) {

                    cost[nextCity][newFlights] = newCost;

                    pq.offer(
                        new int[]{
                            newCost,
                            nextCity,
                            newFlights
                        }
                    );
                }
            }
        }
        return -1;
    }
}