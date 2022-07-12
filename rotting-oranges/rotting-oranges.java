class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    dfs(i, j, 2, grid);
            }
        }
        
        int min = 2;
        
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1)
                    return -1;
                min = Math.max(min, cell);
            }
        }
        return min - 2;
    }
    
    public void dfs(int r, int c, int min, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || 1 < grid[r][c] && grid[r][c] < min)
            return;
        
        grid[r][c] = min;
        dfs(r + 1, c, min + 1, grid);
        dfs(r - 1, c, min + 1, grid);
        dfs(r, c + 1, min + 1, grid);
        dfs(r, c - 1, min + 1, grid);
    }
}