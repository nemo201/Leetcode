class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        
        int cur = 0, sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i-1] - nums[i - 2]) {
                cur += 1;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}