class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] efforts = new int[m][n];

        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0],  b[0]));
        pq.offer(new int[]{0, 0, 0});
        efforts[0][0] = 0;

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int effort = cur[0];
            int x = cur[1];
            int y = cur[2];

            if (x == m - 1 && y == n - 1) {
                return effort;
            }

            for (int[] dir :dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newEffort = Math.max (Math.abs(heights[nx][ny] - heights[x][y]), effort);
                    if (newEffort < efforts[nx][ny]) {
                        efforts[nx][ny] = newEffort;
                        pq.offer(new int[]{newEffort, nx, ny});
                    }
                }
            }
        }
        return 0;
    }
}