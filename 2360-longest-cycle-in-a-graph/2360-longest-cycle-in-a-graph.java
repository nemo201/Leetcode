class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        int[] indegree = new int[n];
        
        for (int edge : edges) {
            if (edge != -1)
                indegree[edge]++;
        }
        
        Queue<Integer> q = new LinkedList();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            visit[node] = true;
            int nei = edges[node];
            if (nei != -1) {
                indegree[nei]--;
                if (indegree[nei] == 0)
                    q.offer(nei);
            }
        }
        
        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                int nei = edges[i];
                int count = 1;
                visit[i] = true;
                // Iterate in the cycle.
                while (nei != i) {
                    visit[nei] = true;
                    count++;
                    nei = edges[nei];
                }
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }
}