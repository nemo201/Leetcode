class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                int[] ans = new int[2];
                int i = mid;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                ans[0] = i + 1;
                i = mid;
                while (i < nums.length &&nums[i] == target) {
                    i++;
                }
                ans[1] = i - 1;
                return ans;
            }
        }
        return new int[]{-1, -1};
    }
}