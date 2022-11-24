class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int r, int c, int i, char[][] board, String word) {
        if (i == word.length())
            return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || word.charAt(i) != board[r][c] || board[r][c] == '#')
            return false;
        
        char ch = board[r][c];
        board[r][c] = '#';
        
        boolean result;
        
        result = dfs(r + 1, c, i + 1, board, word) || dfs(r, c + 1, i + 1, board, word) || dfs(r - 1, c, i + 1, board, word) || dfs(r, c - 1, i + 1, board, word);
        
        board[r][c] = ch;
        
        return result;
    }
}