class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int parentA = find(parents, a);
            int parentB = find(parents, b);
            
            if (parentA == parentB)
                return edge;
            else
                union(parents, parentA, parentB);
        }
        return new int[]{-1, -1};
    }
    
    private int find(int[] parents, int v) {
        if (parents[v] < 0)
            return v;
        return find(parents, parents[v]);
    }
    
    private void union(int[] parents, int a, int b) {
        if (parents[a] > parents[b]) {
            union(parents, b, a);
        }
        parents[b] = a;
    }
}