class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int []edge : edges) {
            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[n + 1];

            if (hasPath(adj, u, v, visited)) {
                return edge;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }

    private boolean hasPath(List<List<Integer>> adj, int u, int v, boolean[] visited) {
        if (u == v) {
            return true;
        }

        visited[u] = true;

        for (int nei : adj.get(u)) {
            if (!visited[nei]) {
                if (hasPath(adj, nei, v, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}