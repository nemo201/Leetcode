class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 1)
            return nums[0];
        int f1= helper(0, nums.size() -1, nums);
        int f2 = helper(1, nums.size(), nums);
        
        return max(f1, f2);
    }
    
    int helper(int i, int j, vector<int>& nums) {
        int rob1 = 0, rob2 = 0;
        
        for (; i < j; i++) {
            int temp = max(nums[i] + rob1, rob2);
            rob1 = rob2; 
            rob2 = temp;
        }
        return rob2;
    }
};