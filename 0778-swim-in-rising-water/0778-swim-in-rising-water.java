class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int time = node[2];

            if (x == n - 1 && y == n - 1) {
                return Math.max(time, grid[n - 1][n - 1]);
            }

            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int nextTime = Math.max(time, grid[nx][ny]);
                    pq.offer(new int[]{nx, ny, nextTime});
                }
            }
        }
        return -1;
    }
}