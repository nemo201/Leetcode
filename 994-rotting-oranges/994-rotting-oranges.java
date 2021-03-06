// BFS O(1) space
class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int timestamp = 2;
        while (helper(timestamp, grid, ROWS, COLS))
            timestamp++;
        
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1)
                    return -1;
            }
        }
        return timestamp - 2;
    }
    
    private boolean helper(int timestamp, int[][] grid, int ROWS, int COLS) {
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean toBeCont = false;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if(grid[row][col] == timestamp) {
                    for (int[] d : directions) {
                        int nRow = row + d[0];
                        int nCol = col + d[1];
                        
                        if (nRow >= 0 && nRow < ROWS && nCol >= 0 && nCol < COLS)
                            if (grid[nRow][nCol] == 1) {
                                grid[nRow][nCol] = timestamp + 1;
                                toBeCont = true;
                            }
                    }
                }
            }
        }
        return toBeCont;
    }
}
// BFS O(n) space
// class Solution {
//     private static final int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//     public int orangesRotting(int[][] grid) {
//         Queue<int[]> q = new LinkedList<>();
//         int ROWS = grid.length, COLS = grid[0].length;
//         int fresh = 0;
        
//         for (int r = 0; r < ROWS; r++) {
//             for (int c = 0; c < COLS; c++) {
//                 if (grid[r][c] == 2)
//                     q.offer(new int[]{r, c});
//                 if (grid[r][c] == 1)
//                     fresh++;
//             }
//         }
//         //level end
//         q.offer(new int[]{-1, -1});
//         int mins = -1;
        
//         while (!q.isEmpty()) {
//             int[] cell = q.poll();
//             int row = cell[0];
//             int col = cell[1];
            
//             if (row == -1){
//                 mins++;
                
//                 if (!q.isEmpty())
//                     q.offer(new int[]{-1, -1});
//             } else {
//                 for (int[] nei : getNei(row, col, grid)) {
//                     int nRow = nei[0];
//                     int nCol = nei[1];
                    
//                     if (grid[nRow][nCol] == 1){
//                         grid[nRow][nCol] = 2;
//                         fresh--;
//                         q.offer(new int[]{nRow, nCol});
//                     }
//                 }
//             } 
//         }
//         return fresh == 0 ? mins : -1;
//     }
    
//     private List<int[]> getNei(int row, int col, int[][] grid) {
//         List<int[]> list = new ArrayList<>();
        
//         for (int i = 0; i < dir.length; i++) {
//             int newRow = row + dir[i][0];
//             int newCol = col + dir[i][1];
            
//             if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length)
//                 continue;
            
//             list.add(new int[]{newRow, newCol});
//         }
//         return list;
//     }
// }

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