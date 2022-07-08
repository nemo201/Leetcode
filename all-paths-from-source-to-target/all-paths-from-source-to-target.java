class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        
        if (graph == null || graph.length == 0)
            return ans;
        
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        q.offer(path);
        
        while (!q.isEmpty()) {
            List<Integer> curPath = q.poll();
            
            int node = curPath.get(curPath.size() - 1);
            for (int nei : graph[node]) {
                List<Integer> tmp = new ArrayList<>(curPath);
                tmp.add(nei);
                if (nei == graph.length - 1)
                    ans.add(new ArrayList<>(tmp));
                else
                    q.add(new ArrayList<>(tmp));
            }
        }
        return ans;
    }
}
// DFS
// class Solution {
//     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//         List<List<Integer>> ans = new ArrayList();
//         List<Integer> path = new ArrayList();
        
//         path.add(0);
//         dfs(graph, 0, ans, path);
//         return ans;
//     }
    
//     private void dfs(int[][] graph, int start, List<List<Integer>> ans, List<Integer> path){
//         if (start == graph.length - 1) {
//             ans.add(new ArrayList(path));
//             return;
//         }
        
//         for (int nextNode : graph[start]) {
//             path.add(nextNode);
//             dfs(graph, nextNode, ans, path);
//             path.remove(path.size() - 1);
//         }
//     }
// }