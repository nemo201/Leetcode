class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> result;
        int n = nums.size();
        int prefix = 1;
        
        for (int i = 0; i < n; i++) {
            result.push_back(prefix);
            prefix *= nums[i];
        }
        
        int postfix = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
};