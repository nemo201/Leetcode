class Solution {
    public int shortestBridge(int[][] A) {
        if (A.length == 0)
            return 0;
        
        int n = A.length;
        int m = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean marked = false;
        
        for (int i = 0; i < n; i++) {
            if (marked) {
                break;
            }
            
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    marked = true;
                    break;
                }
            }
        }
        
        int bridge = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = queue.poll();
                int x = curPoint[0];
                int y = curPoint[1];
                
                if (x > 0 && A[x - 1][y] == 0) {
                    queue.offer(new int[]{x - 1, y});
                    A[x - 1][y] = 2;
                }
                if (x < n - 1 && A[x + 1][y] == 0) {
                    queue.offer(new int[]{x + 1, y});
                    A[x + 1][y] = 2;
                }
                if (y > 0 && A[x][y - 1] == 0) {
                    queue.offer(new int[]{x, y - 1});
                    A[x][y - 1] = 2;
                }
                if (y < m - 1 && A[x][y + 1] == 0) {
                    queue.offer(new int[]{x, y + 1});
                    A[x][y + 1] = 2;
                }

                // once we find the second island, return current bridge value
                if (x > 0 && A[x - 1][y] == 1 || x < n - 1 && A[x + 1][y] == 1
                || y > 0 && A[x][y - 1] == 1 || y < m - 1 && A[x][y + 1] == 1) {
                    return bridge;
                }
            }
            bridge++;
        }
        return bridge;
    }

    public void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        queue.offer(new int[]{i, j});
        dfs(grid, i - 1, j, queue);
        dfs(grid, i + 1, j, queue);
        dfs(grid, i, j - 1, queue);
        dfs(grid, i, j + 1, queue);
    }
}