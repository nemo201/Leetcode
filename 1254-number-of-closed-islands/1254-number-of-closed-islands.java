class Solution {
    public int closedIsland(int[][] grid) {
        int ans = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j))
                        ans++;
                }
            }
        }
        return ans;
    }
    
    private boolean dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return false;
        
        if (grid[row][col] == 1)
            return true;
        
        grid[row][col] = 1;
        
        boolean res = true;
        
        res = res & dfs(grid, row + 1, col) & dfs(grid, row, col + 1) & dfs(grid, row - 1, col) & dfs(grid, row, col - 1);
        return res;
    }
}