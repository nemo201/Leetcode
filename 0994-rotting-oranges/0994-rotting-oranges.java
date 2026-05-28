class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int min = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int[] dir : dirs) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        q.offer(new int[]{nr, nc});
                        fresh--;
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                min++;
            }
        }
        return (fresh == 0) ? min : -1;
    }
}