class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones)
            pq.offer(s);
        
        int x, y;
        while (pq.size() > 1) {
            y = pq.poll();
            x = pq.poll();
            
            if (y > x)
                pq.offer(y - x);
        }
        if (pq.size() == 0)
            return 0;
        return pq.poll();
    }
}