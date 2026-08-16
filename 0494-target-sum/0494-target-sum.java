class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper (nums, target, 0, 0);
    }

    private int helper (int[] nums, int target, int i, int currentSum) {
        if (i == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        int add = helper (nums, target, i + 1, currentSum + nums[i]);
        int sub = helper (nums, target, i + 1, currentSum - nums[i]);

        return add + sub;
    }
}