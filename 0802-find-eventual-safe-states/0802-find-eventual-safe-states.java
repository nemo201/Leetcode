class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            for (int j = 0; j < graph[i].length; j++) {
                int next = graph[i][j];
                adj.get(next).add(i);
            }
        }
        
        boolean[] terminal = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
                terminal[i] = true;
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : adj.get(node)) {
                outdegree[nei]--;

                if (outdegree[nei] == 0) {
                    q.offer(nei);
                    terminal[nei] = true;
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < terminal.length; i++) {
            if (terminal[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}