class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size(), cols = matrix[0].size(), start = 0;
        int end = rows * cols - 1;
        
        while (start <= end) {
            int mid = (end + start) / 2;
            if (matrix[mid / cols][mid % cols] == target)
                return true;
            else if (matrix[mid / cols][mid % cols] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
};