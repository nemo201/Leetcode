class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int time = cur[1];

            for (int[] nei : adj.get(node)) {
                int nextNode = nei[0];
                int nextTime = nei[1];

                if (time + nextTime < dist[nextNode]) {
                    dist[nextNode] = time + nextTime;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        int minTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            } 
            minTime = Math.max(minTime, dist[i]);
        }
        return minTime;
    }
}