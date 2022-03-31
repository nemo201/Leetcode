class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        if (M.empty())
            return 0;
        int n = M.size();
        vector<bool> visited(n, false);
        int grp = 0;
        for (int i = 0; i < n; i++) {
            grp += !visited[i] ? dfs(i, M, visited), 1 : 0;
        }
        return grp;
    }
    
    void dfs(int i, vector<vector<int>>& M, vector<bool>& visited) {
        visited[i] = true;
        for (int j = 0; j < visited.size(); j++) {
            if (i != j && M[i][j] && !visited[j])
                dfs(j, M, visited);
        }
    }
};