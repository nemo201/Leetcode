class Solution {
    public int maxSubArray(int[] nums) {
        int max = 0, ans = Integer.MIN_VALUE;
        
        for (int n : nums) {
            max += n;
            ans = Math.max(ans, max);
            
            if (max < 0)
                max = 0;
        }
        return ans;
    }
}