class Solution {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        long pairs = 0;
        long sizeComponent = 0;
        long remaining = n;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sizeComponent = dfs(i, adj, visited);
                pairs += sizeComponent * (remaining - sizeComponent);
                remaining -= sizeComponent;
            }
        }
        return pairs;
    }
    public int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        int count = 1;
        visited[node] = true;
        
        if (!adj.containsKey(node))
            return count;
        
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                count += dfs(nei, adj, visited);
            }
        }
        return count;
    }
}