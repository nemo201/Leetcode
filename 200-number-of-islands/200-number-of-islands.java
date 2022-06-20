class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1')
                    ans += dfs(i, j, grid);
            }
        }
        return ans;
    }
    
    private int dfs (int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0')
            return 0;
        
        grid[r][c] = '0';
        dfs(r + 1, c, grid);
        dfs(r - 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r, c - 1, grid);
        
        return 1;
    }
}