class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //boolean isPossible = true;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topological = new int[numCourses];
        
        //create adjlist
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            List<Integer> list = adj.getOrDefault(src, new ArrayList());
            list.add(dest);
            adj.put(src, list);
            indegree[dest]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        //all all vertices with 0 ndegree to q
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        
        int i = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            topological[i++] = node;
            
            if (adj.containsKey(node)) {
                for (Integer nei : adj.get(node)) {
                    indegree[nei]--;
                    
                    if (indegree[nei] == 0)
                        q.offer(nei);
                }
            }
        }
        
        if (i == numCourses)
            return topological;
        
        return new int[0];
    }
}