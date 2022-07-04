class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Uf obj = new Uf(n);
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int[] edge : logs) {
            int time = edge[0];
            int x = edge[1];
            int y = edge[2];
            
            obj.union(x, y);
            
            if (obj.getCount() == 1)
                return time;
        }
        return -1;
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