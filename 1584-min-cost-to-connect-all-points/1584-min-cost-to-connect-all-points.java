class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));
        
        boolean[] inMTS = new boolean[n];
        
        heap.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        
        while (edgesUsed < n) {
            Pair<Integer, Integer> topElement = heap.poll();
            
            int weight = topElement.getKey();
            int curNode = topElement.getValue();
            
            if (inMTS[curNode])
                continue;
            
            inMTS[curNode] = true;
            mstCost += weight;
            edgesUsed++;
            
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if(!inMTS[nextNode]) {
                    int nextWeight = Math.abs(points[curNode][0] - points[nextNode][0]) + 
                                     Math.abs(points[curNode][1] - points[nextNode][1]);
                    
                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
        }
        return mstCost;
    }
}