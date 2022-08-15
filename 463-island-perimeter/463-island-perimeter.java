class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    ans += 4;
                    
                    if (r > 0 && grid[r - 1][c] == 1)
                        ans -= 2;
                    
                    if (c > 0 && grid[r][c - 1] == 1)
                        ans -= 2;
                }
            }
        }
        return ans;
    }
}