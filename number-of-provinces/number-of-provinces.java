class Solution {
    class Uf {
        int[] root;
        int[] rank;
        int count;
        
        Uf(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            
            if (rx != ry) {
                if (rank[rx] < rank[ry])
                    root[rx] = ry;
                else {
                    root[ry] = rx;
                    rank[rx]++;
                }
                count--;
            }
        }
        
        int getCount() {
            return count;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0)
            return 0;
        int n = isConnected.length;
        Uf uf = new Uf(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.getCount();
    }
}