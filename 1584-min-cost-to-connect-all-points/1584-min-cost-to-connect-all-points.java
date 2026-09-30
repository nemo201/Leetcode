class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});
        int edges = 0;

        while (!pq.isEmpty() && edges < n) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int node = cur[1];
            
            if (visited[node]) {
                continue;
            }

            totalCost += cost;
            visited[node] = true;
            edges++;

            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int nextCost = Math.abs(points[node][0] - points[nextNode][0]) + Math.abs(points[node][1] - points[nextNode][1]);
                    pq.offer(new int[] {nextCost, nextNode});
                }
            }
        }
        return totalCost;
    }
}