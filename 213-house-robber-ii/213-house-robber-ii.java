class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        
        int n = nums.length;
        int f1 = robHelper(0, n - 1, nums);
        int f2 = robHelper(1, n, nums);
        
        return Math.max(f1, f2);
    }
    
    private int robHelper(int i, int j, int[] nums) {
        int rob1 = 0, rob2 = 0;
        
        for (; i < j; i++) {
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}