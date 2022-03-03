class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& nums) {
        if (nums.size() < 3)
            return 0;
        int sum = 0, cur = 0;
        
        for (int i = 2; i < nums.size(); i++) {
            if (nums[i] - nums[i - 1] == nums[i-1] - nums[i - 2]) {
                cur++;
                sum += cur;
            } else
                cur = 0;
        }
        return sum;
    }
};