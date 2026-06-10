class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> allEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                int[] curEdge = {w, i, j};
                allEdges.add(curEdge);
            }
        }
        Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        int edgesUsed = 0;

        for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; i++) {
            int n1 = allEdges.get(i)[1];
            int n2 = allEdges.get(i)[2];
            int w = allEdges.get(i)[0];

            if (uf.union(n1, n2)) {
                cost += w;
                edgesUsed++;
            }
        }
        return cost;
    }

    class UnionFind {
        int parent[];
        int rank[];

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) {
                return false;
            }
            
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[px]++;
            }
            return true;
        }
    }
}