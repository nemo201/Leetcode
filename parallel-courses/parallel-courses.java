class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        //indegree
        int[] incount = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] relation : relations) {
            adj.get(relation[0]).add(relation[1]);
            incount[relation[1]]++;
        }
        
        int step = 0;
        int studiedCount = 0;
        List<Integer> q = new ArrayList<>();
        
        for (int node = 1; node < n + 1; node++) {
            if (incount[node] == 0)
                q.add(node);
        }
        
        while (!q.isEmpty()) {
            step++;
            List<Integer> nextq = new ArrayList<>();
            for (int node : q) {
                studiedCount++;
                for (int endNode : adj.get(node)) {
                    incount[endNode]--;
                    
                    if (incount[endNode] == 0)
                        nextq.add(endNode);
                }
            }
            q = nextq;
        }
        return studiedCount == n ? step : -1;
    }
}