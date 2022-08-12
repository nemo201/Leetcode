class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org = image[sr][sc];
        if (org == color)
            return image;
        helper(image, sr, sc, org, color);
        return image;
    }
    
    private void helper(int[][] image, int r, int c, int org, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != org)
            return;
        image[r][c] = color;
        helper(image, r + 1, c, org, color);
        helper(image, r - 1, c, org, color);
        helper(image, r, c + 1, org, color);
        helper(image, r, c - 1, org, color);
    }
}
