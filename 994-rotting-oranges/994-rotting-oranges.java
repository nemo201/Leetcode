class Solution {
    private static final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        int fresh = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 2)
                    q.offer(new int[]{r, c});
                else if (grid[r][c] == 1)
                    fresh++;
            }
        }
        
        q.offer(new int[]{-1, -1});
        
        int min = -1;
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            
            if (row == -1) {
                min++;
                
                if (!q.isEmpty())
                    q.offer(new int[]{-1, -1});
            } else {
                for (int[] nei : getNei(row, col, grid)) {
                    int nRow = nei[0];
                    int nCol = nei[1];
                    
                    if (grid[nRow][nCol] == 1) {
                        grid[nRow][nCol] = 2;
                        fresh--;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
        }
        return fresh == 0 ? min : - 1;
    }
    
    private List<int[]> getNei(int row, int col, int[][] grid) {
        List<int[]> nei = new ArrayList<>();
        
        for (int i = 0; i < dir.length; i++) {
            int newR = row + dir[i][0];
            int newC = col + dir[i][1];
            
            if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length)
                continue;
            
            nei.add(new int[]{newR, newC});
        }
        return nei;
    }
}

// DFS
// class Solution {
//     public int orangesRotting(int[][] grid) {
//         if (grid.length == 0 || grid == null)
//             return 0;
        
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 2)
//                     dfs(i, j, 2, grid);
//             }
//         }
        
//         int min = 2;
        
//         for (int[] row : grid) {
//             for (int cell : row) {
//                 if (cell == 1)
//                     return -1;
//                 min = Math.max(min, cell);
//             }
//         }
//         return min - 2;
//     }
    
//     public void dfs(int r, int c, int min, int[][] grid) {
//         if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || 1 < grid[r][c] && grid[r][c] < min)
//             return;
        
//         grid[r][c] = min;
//         dfs(r + 1, c, min + 1, grid);
//         dfs(r - 1, c, min + 1, grid);
//         dfs(r, c + 1, min + 1, grid);
//         dfs(r, c - 1, min + 1, grid);
//     }
// }