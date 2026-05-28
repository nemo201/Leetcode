class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] outdegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            outdegree[i] = graph[i].length;
            for (int v : graph[i]) {
                adj.get(v).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] terminalNode = new boolean[graph.length];

        while (!q.isEmpty()) {
            int node = q.poll();
            terminalNode[node] = true;

            for (int nei : adj.get(node)) {
                outdegree[nei]--;

                if (outdegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < terminalNode.length; i++) {
            if (terminalNode[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}