class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});
        int edge = 0;

        while (!pq.isEmpty() && edge < n) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];

            if (visited[node]) {
                continue;
            }

            totalCost += cost;
            edge--;
            visited[node] = true;

            for (int next = 0; next < n; next++) {
                if (!visited[next]) {
                    int nextCost = Math.abs(points[node][0] - points[next][0]) + Math.abs(points[node][1] - points[next][1]);
                    pq.offer(new int[]{nextCost, next});
                }
            }
        }
        return totalCost;
    }
}