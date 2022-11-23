class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char curr_char = board[i][j];
                if (curr_char != '.') {
                    if (!seen.add(curr_char + "row" + i) ||
                        !seen.add(curr_char + "col" + j) ||
                        !seen.add(curr_char + "box" + i / 3 + "-" + j / 3))
                        
                        return false;
                }
            }
        }
        return true;
    }
}