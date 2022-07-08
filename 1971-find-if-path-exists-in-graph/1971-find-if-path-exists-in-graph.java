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
//         BFS
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(source);
//         Set<Integer> set = new HashSet<>();
//         set.add(source);
        
//         while(!q.isEmpty()) {
//             int node = q.poll();
            
//             if (node == destination)
//                 return true;
            
//             for (int nei : adj.get(node)) {
                
//                 if (!set.contains(nei)) {
//                     set.add(nei);
//                     q.offer(nei);
//                 }
//             }
//         }
//         return false;
        
//         DFS
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet();
        stack.push(source);
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            if (node == destination)
                return true;
            
            if (visited.contains(node))
                continue;
            
            visited.add(node);
            
            for (int nei : adj.get(node)) {
                stack.push(nei);
            }
        }
        return false;
    }
}