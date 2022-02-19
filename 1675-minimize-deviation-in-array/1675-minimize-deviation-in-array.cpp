class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        set<int> s;
        for (int &num : nums) {
            s.insert(num % 2 ? num*2 : num);
        }
        int res = *s.rbegin() - *s.begin();
        while (*s.rbegin() % 2 == 0) {
            s.insert(*s.rbegin() / 2);
            s.erase(*s.rbegin());
            res = min(res, *s.rbegin() - *s.begin());
        }
        return res;
    }
};