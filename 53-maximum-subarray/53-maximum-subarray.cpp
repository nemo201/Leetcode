class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0, maax = INT_MIN;
        for (int num : nums) {
            sum += num;
            maax = max(maax, sum);
            
            if (sum < 0)
                sum = 0;
        }
        return maax;
    }
};