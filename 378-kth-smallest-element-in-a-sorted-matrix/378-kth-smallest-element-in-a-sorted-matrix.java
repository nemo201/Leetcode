class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = -1;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        for (int r = 0; r < Math.min(m, k); r++) {
            minHeap.offer(new int[]{matrix[r][0], r, 0});
        }
        
        for (int i = 1; i <= k; i++) {
            int[] top = minHeap.poll();
            int r = top[1], c = top[2];
            ans = top[0];
            
            if (c + 1 < n)
                minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
        }
        return ans;
    }
}