class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Queue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));
        
        boolean[] visited = new boolean[n];
        int cost = 0;
        int edges = 0;
        heap.add(new Pair(0, 0));
        
        while (edges < n) {
            Pair<Integer, Integer> top = heap.poll();
            int weight = top.getKey();
            int curNode = top.getValue();
            
            if (visited[curNode])
                continue;
            visited[curNode] = true;
            cost += weight;
            edges++;
            
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int nextWeight = Math.abs(points[curNode][0] - points[nextNode][0]) + Math.abs(points[curNode][1] - points[nextNode][1]);
                    
                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
        }
        return cost;
    }
}