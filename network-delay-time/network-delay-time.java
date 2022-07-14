class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});
        
        boolean[] visited = new boolean[n + 1];
        int time = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int weight = cur[0];
            int curNode = cur[1];
            
            if (visited[curNode])
                continue;
            
            visited[curNode] = true;
            time = weight;
            n--;
            
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    pq.add(new int[]{weight + map.get(curNode).get(next), next});
                }
            }
        }
        return n == 0 ? time : -1;
    }
}