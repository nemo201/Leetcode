class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        int col = image[sr][sc];
        if (col != newColor)
            dfs(image, sr, sc, col, newColor);
        return image;
    }
    
    void dfs(vector<vector<int>>& image, int r, int c, int col, int newColor) {
        if (image[r][c] == col) {
            image[r][c] = newColor;
            if (r >= 1)
                dfs(image, r - 1, c, col, newColor);
            if (c >= 1)
                dfs(image, r, c - 1, col, newColor);
            if (r+1 < image.size())
                dfs(image, r + 1, c, col, newColor);
            if (c+1 < image[0].size())
                dfs(image, r, c + 1, col, newColor);
        }
    }
};