class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        int leftRow[] = new int[n];
        int upperDia[] = new int[2*n - 1];
        int lowerDia[] = new int[2*n - 1];
        fun(0, board, ans, leftRow, upperDia, lowerDia);
        
        return ans;
    }
    
    private void fun(int col, char[][] board, List<List<String>> ans, int[] leftRow, int[] upperDia, int[] lowerDia) {
        if (col == board.length) {
            ans.add(construct(board));
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDia[row+col] == 0 && upperDia[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDia[row+col] = 1;
                upperDia[board.length-1 + col - row] = 1;
                fun (col + 1, board, ans, leftRow, upperDia, lowerDia);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDia[row+col] = 0;
                upperDia[board.length-1 + col - row] = 0;
            }
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}