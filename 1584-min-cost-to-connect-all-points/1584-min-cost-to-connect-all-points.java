class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        Queue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        boolean[] visited = new boolean[n];
        
        minHeap.add(new Pair(0, 0));
        int cost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n) {
            Pair<Integer, Integer> cell = minHeap.poll();
            int weight = cell.getKey();
            int curNode = cell.getValue();
            
            if (visited[curNode])
                continue;
            
            visited[curNode] = true;
            cost += weight;
            edgesUsed++;
            
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int nextWeight = Math.abs(points[curNode][0] - points[nextNode][0]) + Math.abs(points[curNode][1] - points[nextNode][1]);
                    minHeap.add(new Pair(nextWeight, nextNode));
                }
            }
        }
        return cost;
    }
}
// Kruskal
// class Solution {
    
//     class UnionFind{
//         int[] root;
//         int[] rank;
        
//         public UnionFind(int size) {
//             root = new int[size];
//             rank = new int[size];
            
//             for (int i = 0; i < size; i++) {
//                 root[i] = i;
//                 rank[i] = 1;
//             }
//         }
        
//         public int find(int x) {
//             if (x == root[x])
//                 return x;
//             return root[x] = find(root[x]);
//         }
        
//         public boolean union(int x, int y) {
//             int Rx = find(x);
//             int Ry = find(y);
            
//             if (Rx == Ry)
//                 return false;
            
//             if (rank[Rx] < rank[Ry])
//                 root[Rx] = Ry;
//             else {
//                 root[Ry] = Rx;
//                 rank[Rx]++;
//             }
//             return true;
//         }
//     }
    
//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
//         List<int[]> allEdges = new ArrayList<>();
        
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                
//                 int[] curEdge = {weight, i, j};
//                 allEdges.add(curEdge);
//             }
//         }
//         Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));
        
//         UnionFind uf = new UnionFind(n);
//         int cost = 0;
//         int edgesUsed = 0;
        
//          for (int i = 0; i < allEdges.size() && edgesUsed < n - 1; i++) {
//             int n1 = allEdges.get(i)[1];
//             int n2 = allEdges.get(i)[2];
//             int weight = allEdges.get(i)[0];
            
//             if (uf.union(n1, n2)){
//                 cost += weight;
//                 edgesUsed++;
//             }
//         }
//         return cost;
//     }
// }