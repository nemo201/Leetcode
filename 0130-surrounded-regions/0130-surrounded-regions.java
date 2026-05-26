class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == r - 1 || j == 0 || j == c - 1)) {
                    dfs(i, j, board);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }

        board[r][c] = 'T';

        dfs(r + 1, c, board);
        dfs(r - 1, c, board);
        dfs(r, c + 1, board);
        dfs(r, c - 1, board);
    }
}