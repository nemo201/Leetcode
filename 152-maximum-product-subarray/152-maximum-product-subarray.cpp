class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        
        int Max = nums[0], Min = nums[0], result = nums[0];
        
        for (int i = 1; i < nums.size(); i++) {
            int temp = Max;
            Max = max(max(Max * nums[i], Min * nums[i]), nums[i]);
            Min = min(min(temp * nums[i], Min * nums[i]), nums[i]);
            
            if (result < Max)
                result = Max;
        }
        return result;
    }
};