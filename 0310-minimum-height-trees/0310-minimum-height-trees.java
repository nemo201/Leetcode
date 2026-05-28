class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        if (n == 1)
            return Collections.singletonList(0);
        
        if (n == 2)
            return Arrays.asList(0, 1);

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei : adj.get(node)) {
                    indegree[nei]--;

                    if (indegree[nei] == 1) {
                        q.offer(nei);
                    }
                }
            }
        }
        return new ArrayList<>(q);
    }
}