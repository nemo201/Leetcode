class Solution {
    public int removeStones(int[][] stones) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (helper(stones[i], stones[j])) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] visited = new int[stones.length];
        int count = 0;

        for (int i = 0; i < stones.length; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(stones, adj, visited, i);
            }
        }
        return stones.length - count;
    }

    private void dfs(int[][] stones, Map<Integer, List<Integer>> adj, int[] visited, int src) {
        visited[src] = 1;
        for (int nei : adj.get(src)) {
            if (visited[nei] == 0) {
                dfs(stones, adj, visited, nei);
            }
        }
    }

    boolean helper(int[] a, int[] b) {
        return a[0] == b[0] || a[1] == b[1];
    }
}