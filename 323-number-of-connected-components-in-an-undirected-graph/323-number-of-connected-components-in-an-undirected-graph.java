class Solution {
    public int countComponents(int n, int[][] edges) {
        Uf obj = new Uf(n);
        
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            obj.union(x, y);
        }
        return obj.getCount();
    }
    
    class Uf {
        private int[] root;
        private int[] rank;
        private int count;
        
        public Uf(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;
            
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find (int x) {
            if (x == root[x])
                return x;
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            
            if (rx != ry) {
                if (rank[rx] > rank[ry])
                    root[ry] = rx;
                else if (rank[rx] < rank[ry])
                    root[rx] = ry;
                else {
                    root[ry] = root[rx];
                    rank[rx]++;
                }
                count--;
            }
        }
        
        public int getCount() {
            return count;
        }
    }
}