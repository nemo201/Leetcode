class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newCol) {
        int col = image[sr][sc];
        if (col != newCol)
            dfs(image, sr, sc, col, newCol);
        return image;
    }
    
    void dfs(vector<vector<int>>& image, int r, int c, int col, int newCol) {
        if (image[r][c] == col) {
            image[r][c] = newCol;
            
            if (r >= 1)
                dfs (image, r - 1, c, col, newCol);
            if (c >= 1)
                dfs (image, r, c - 1, col, newCol);
            if (r + 1 < image.size())
                dfs (image, r + 1, c, col, newCol);
            if (c + 1 < image[0].size())
                dfs (image, r, c + 1, col, newCol);
        }
    }
};