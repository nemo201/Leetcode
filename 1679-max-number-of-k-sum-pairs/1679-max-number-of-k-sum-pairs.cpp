class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        int res = 0;
        for (int num : nums) {
            map[num]++;
        }
        
        for (auto it = map.begin(); it != map.end(); it++) {
            int num = it -> first, count = it -> second;
            if (k - num == num)
                res += count / 2;
            else if (map.count(k - num)) {
                int Min = min(count, map[k - num]);
                res += Min;
                map[num] -= Min;
                map[k - num] -= Min;
            }
        }
        return res;
    }
};