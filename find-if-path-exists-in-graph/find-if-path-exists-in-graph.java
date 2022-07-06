class Solution {
    boolean flag;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        flag = false;
        
        if (source == destination)
            return true;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet();
        
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        dfs(adj, visited, source, destination);
        
        return flag;
    }
    
    private void dfs(Map<Integer, List<Integer>> adj, Set<Integer> visited, int source, int destination) {
        if (visited.contains(source) || flag)
            return;
        
        visited.add(source);
        
        for (int nei : adj.get(source)) {
            if (nei == destination){
                flag = true;
                break;
            }
            if (!visited.contains(nei))
                dfs(adj, visited, nei, destination);
        }
    }
}