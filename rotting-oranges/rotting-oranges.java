class Solution {
    private static final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        
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
    
    public void dfs(int row, int col, int min, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || 1 < grid[row][col] && grid[row][col] < min)
            return;
        
        grid[row][col] = min;
        
        dfs (row + 1, col, min + 1, grid);
        dfs (row - 1, col, min + 1, grid);
        dfs (row, col + 1, min + 1, grid);
        dfs (row, col - 1, min + 1, grid);

    }
}