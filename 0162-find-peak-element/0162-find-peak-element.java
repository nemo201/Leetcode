class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            //asccending slope
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } //descending slope
            else {
                right = mid;
            }
        }
        return left;
    }
}