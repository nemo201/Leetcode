class Solution {
public:
    void dfs(vector<vector<int>>& grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.size() || j == grid[i].size() || grid[i][j] != 1)
            return;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    
    int numEnclaves(vector<vector<int>>& grid) {
        for (auto i = 0; i < grid.size(); i++) {
            for (auto j = 0; j < grid[0].size(); j++) {
                if (i * j == 0 || i == grid.size() - 1 || j == grid[i].size() - 1)
                    dfs(grid, i, j);
            }
        }
        return accumulate(begin(grid), end(grid), 0, [](int s, vector<int>& r) {
            return s + accumulate(begin(r), end(r), 0); });
        }
};