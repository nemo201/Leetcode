class Solution {
    public long countPairs(int n, int[][] edges) {
//         Map<Integer, List<Integer>> adj = new HashMap<>();
//         for (int[] edge : edges) {
//             adj.computeIfAbsent(edge[0], k -> new ArrayList<Integer>()).add(edge[1]);
//             adj.computeIfAbsent(edge[1], k -> new ArrayList<Integer>()).add(edge[0]);
//         }
        
//         boolean[] visited = new boolean[n];
//         long pairs = 0;
//         long sizeComponent = 0;
//         long remaining = n;
        
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 // sizeComponent = dfs(i, adj, visited);
//                 sizeComponent = bfs(i, adj, visited);
//                 pairs += sizeComponent * (remaining - sizeComponent);
//                 remaining -= sizeComponent;
//             }
//         }
//         return pairs;
        
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        Map<Integer, Integer> componentSize = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            if (componentSize.containsKey(parent))
                componentSize.put(parent, componentSize.get(parent) + 1);
            else
                componentSize.put(parent, 1);
        }
        long numberOfPaths = 0;
        long remainingNodes = n;
        for (int component : componentSize.values()) {
            numberOfPaths += component * (remainingNodes - component);
            remainingNodes -= component;
        }
        return numberOfPaths;
    }
    public int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        int count = 1;
        visited[node] = true;
        
        if (!adj.containsKey(node))
            return count;
        
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                count += dfs(nei, adj, visited);
            }
        }
        return count;
    }
    
    public int bfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        int count = 1;
        
        Queue<Integer> q = new LinkedList();
        q.offer(node);
        visited[node] = true;
        
        while (!q.isEmpty()) {
            node = q.poll();
            
            if (!adj.containsKey(node))
            return count;
            
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                    count++;
                }
            }
        }
        return count;
    }
}

class UnionFind {
    int[] root;
    int[] rank;
    
    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        
        for (int i = 0; i < size; i++)
            root[i] = i;
    }
    
    public int find(int x) {
        if (root[x]!= x)
            root[x] = find(root[x]);
        return root[x];
    }
    
    public void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        
        if (rx == ry)
            return;
        else if (rank[rx] < rank[ry])
            root[rx] = ry;
        else {
            root[ry] = rx;
            rank[rx]++;
        }
    }
}