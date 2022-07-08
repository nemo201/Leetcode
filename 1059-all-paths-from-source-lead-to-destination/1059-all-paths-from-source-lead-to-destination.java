class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        Set<Integer> visited = new HashSet();
        
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList());
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }
        
        if (map.get(destination).size() > 0)
            return false;
        
        return dfs(source, destination, visited);
    }
    
    private boolean dfs(int s, int d, Set<Integer> visited) {
        if (s == d)
            return true;
        
        visited.add(s);
        
        if (map.get(s).size() < 1)
            return false;
        
        for (Integer node : map.get(s)) {
            if (visited.contains(node) || !dfs(node, d, visited))
                return false;
        }
        
        visited.remove(s);
        return true;
    }
}