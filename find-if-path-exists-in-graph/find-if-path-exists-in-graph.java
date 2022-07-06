class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack();
        stack.push(source);
        Set<Integer> set = new HashSet();
        
        while(!stack.isEmpty()) {
            int node = stack.pop();
            
            if (node == destination)
                return true;
            
            if (set.contains(node))
                continue;
            set.add(node);
            
            for (int nei : adj.get(node)){
                stack.push(nei);
            }
        }
        return false;
    }
}