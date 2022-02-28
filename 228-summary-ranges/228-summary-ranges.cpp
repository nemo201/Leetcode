class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        int start = 0, end = 0;
        vector<string> vec;
        
        for (int i = 0; i < nums.size(); i++) {
            while (i < nums.size() - 1 && nums[i] + 1 == nums[i + 1]) {
                end++;
                i++;
            }
            if (start == end) {
                vec.push_back(to_string(nums[i]));
            } else {
                vec.push_back(to_string(nums[start]) + "->" + to_string(nums[end]));
            }
            end++;
            start = end;
        }
        return vec;
    }
};