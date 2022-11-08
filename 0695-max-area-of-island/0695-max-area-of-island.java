class Solution {
    int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    area = Math.max(area, dfs(grid, i, j));
            }
        }
        return area;
    }
    
    private int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1)
            return 0;
        
        grid[row][col] = 0;
        
        return dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1) + 1; 
    }
}