class Solution {
    public int minCost(int[][] grid) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];
        
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        Deque<int[]> q = new LinkedList<>();
        q.offerFirst(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] node = q.pollFirst();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }

                int cost = (grid[x][y] == i + 1) ? 0 : 1;
                int newCost = dist[x][y] + cost;

                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;

                    if (cost == 0) {
                        q.offerFirst(new int[]{nx, ny});
                    } else {
                        q.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}