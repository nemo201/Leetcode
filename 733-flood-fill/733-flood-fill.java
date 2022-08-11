class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newCol) {
        int color = image[sr][sc];
        if (color != newCol) {
            helper(image, sr, sc, color, newCol);
        }
        return image;
    }
    
    private void helper(int[][] image, int row, int col, int color, int newCol) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != color)
            return;
        
        image[row][col] = newCol;    
        helper(image, row + 1, col, color, newCol);
        helper(image, row, col + 1, color, newCol);
        helper(image, row - 1, col, color, newCol);
        helper(image, row, col - 1, color, newCol);
    }
}
