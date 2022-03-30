class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length, start = 0;
        int end = rows * cols - 1;
        
        while (start <=  end) {
            int mid = (start + end) / 2;
            
            if (matrix[mid / cols][mid % cols] == target)
                return true;
            else if (matrix[mid / cols][mid % cols] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}