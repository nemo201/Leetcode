class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> dp(nums.size(), 1);
        
        int maxx = 1;
        
        for (int j = 0; j < nums.size(); j++) {
            int i = 0;
            while (i < j) {
                if (nums[i] < nums[j]) {
                    dp[j] = max(1 + dp[i], dp[j]);
                }
                i++;
            }
            maxx = max(maxx, dp[j]);
        }
        return maxx;
    }
};