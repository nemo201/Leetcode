class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> record(nums.begin(), nums.end());
        
        if (nums.size() == 0)
            return 0;
        
        int res = 1;
        for (int num : nums) {
            if (record.find(num) == record.end())
                continue;
            record.erase(num);
            int prev = num - 1, next = num + 1;
            while (record.find(prev) != record.end())
                record.erase(prev--);
            while (record.find(next) != record.end())
                record.erase(next++);
            
            res = max(res, next - prev - 1);
        }
        return res;
    }
};