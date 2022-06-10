class Solution {
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])
                return nums[i];
        }
        return nums[0] > nums[nums.length - 1] ? nums[nums.length - 1] : nums[0];
    }
}