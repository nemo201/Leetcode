class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> oEdge = new ArrayList<>();
        
        for (int i = 0; i < wells.length; i++) {
            oEdge.add(new int[]{0, i + 1, wells[i]});
        }
        
        for (int i = 0; i < pipes.length; i++) {
            int[] edge = pipes[i];
            oEdge.add(edge);
        }
        
        Collections.sort(oEdge, (a, b) -> (a[2] - b[2]));
        int totalCost = 0;
        UnionFind uf = new UnionFind(n);
        
        for (int[] edge : oEdge) {
            int h1 = edge[0];
            int h2 = edge[1];
            int cost = edge[2];
            
            if (uf.union(h1, h2))
                totalCost += cost;
        }
        
        return totalCost;
    }
    
    class UnionFind {
        private int[] root;
        private int[] rank;
        
        public UnionFind(int size) {
            root = new int[size + 1];
            rank = new int[size + 1];
            
            for (int i = 0; i < size + 1; i++) {
                root[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        
        public boolean union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            
            if (rx == ry)
                return false;
            
            if (rx != ry) {
                if (rank[rx] > rank[ry])
                    root[ry] = rx;
                else if (rank[rx] < rank[ry])
                    root[rx] = ry;
                else {
                    root[ry] = rx;
                    rank[rx]++;
                }
            }
            return true;
        }
    }
}