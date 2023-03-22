class Solution {
    int min = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(road[1], road[2]));
            adj.computeIfAbsent(road[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(road[0], road[2]));
        }
        boolean[] visit = new boolean[n + 1];
        dfs(1, adj, visit);
        return min;
    }
    
    private void dfs(int n, Map<Integer, List<List<Integer>>> adj, boolean[] visit) {
        visit[n] = true;
        
        if (!adj.containsKey(n))
            return;
        
        for (List<Integer> edge : adj.get(n)) {
            min = Math.min(min, edge.get(1));
            if (!visit[edge.get(0)])
                dfs(edge.get(0), adj, visit);
        }
    }
}