class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        
        if (oldColor != color) {
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int oldColor, int color) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor)
            return;
        
        image[row][col] = color;
        
        dfs(image, row + 1, col, oldColor, color);
        dfs(image, row, col - 1, oldColor, color);
        dfs(image, row, col + 1, oldColor, color);
        dfs(image, row - 1, col, oldColor, color);
    }
}