class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }

        boolean[] visited = new boolean[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                visited[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : adj.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                    visited[nei] = true;
                }
            }
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}