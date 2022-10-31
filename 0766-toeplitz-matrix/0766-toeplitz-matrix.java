class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int l = matrix.length, b = matrix[0].length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}