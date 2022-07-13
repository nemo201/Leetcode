class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> adj = new HashMap<>();
        
        for (int[] time : times) {
            adj.putIfAbsent(time[0], new HashMap<>());
            adj.get(time[0]).put(time[1], time[2]);
        }
        
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        minHeap.add(new int[]{0, k});
        int time = 0;
        boolean[] visited = new boolean[n + 1];
        
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int curNode = cur[1];
            int curWeight = cur[0];
            
            if (visited[curNode] == true)
                continue;
            visited[curNode] = true;
            time = curWeight;
            n--;
            
            if (adj.containsKey(curNode)) {
                for (int next : adj.get(curNode).keySet()) {
                    minHeap.add(new int[]{curWeight + adj.get(curNode).get(next), next});
                }
            }
        }
        return n == 0 ? time : -1;
    }
}