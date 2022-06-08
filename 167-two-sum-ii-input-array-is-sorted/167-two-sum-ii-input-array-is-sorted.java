class Solution {
    public int[] twoSum(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[start] + nums[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else
                end--;
        }
        return null;
    }
}