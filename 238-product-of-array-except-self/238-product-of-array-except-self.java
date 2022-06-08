class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []ans = new int[nums.length];
        int n = nums.length;
        
        int prefix = 1;
        
        for (int i = 0; i < n; i++) {
            ans[i] = prefix;
            prefix *= nums[i];
        }
        
        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= postfix;
            postfix *= nums[i];
        }
        return ans;
    }
}