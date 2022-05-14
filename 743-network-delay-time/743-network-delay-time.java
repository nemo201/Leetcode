class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    
    public void bfs(int[] sigRec, int sNode) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sNode);
        
        sigRec[sNode] = 0;
        
        while (!q.isEmpty()) {
            int curNode = q.remove();
            
            if (!adj.containsKey(curNode))
                continue;
            
            for (Pair<Integer, Integer> edge : adj.get(curNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();
                
                int arrivalTime = sigRec[curNode] + time;
                if (sigRec[neighborNode] > arrivalTime) {
                    sigRec[neighborNode] = arrivalTime;
                    q.add(neighborNode);
                }
            }
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }
        
        int []sigRec = new int[n + 1];
        Arrays.fill(sigRec, Integer.MAX_VALUE);
        
        bfs(sigRec, k);
        
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, sigRec[i]);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}