class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, cnt = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                cnt++;
            else {
                ans += cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }
        ans += cnt * (cnt + 1) / 2;
        return ans;
    }
}