class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> path = new ArrayList();
        
        path.add(0);
        dfs(graph, 0, ans, path);
        return ans;
    }
    
    private void dfs(int[][] graph, int start, List<List<Integer>> ans, List<Integer> path){
        if (start == graph.length - 1) {
            ans.add(new ArrayList(path));
            return;
        }
        
        for (int nextNode : graph[start]) {
            path.add(nextNode);
            dfs(graph, nextNode, ans, path);
            path.remove(path.size() - 1);
        }
    }
}