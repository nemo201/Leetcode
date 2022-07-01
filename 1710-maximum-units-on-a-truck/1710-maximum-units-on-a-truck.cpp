class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int> &lhs, const vector<int> &rhs) {
            return lhs[1] > rhs[1];
        });
        int n = boxTypes.size(), ans = 0;
        for (int i = 0; i < n && truckSize > 0; i++) {
            while (boxTypes[i][0]-- && truckSize--) ans += boxTypes[i][1];
        }
        return ans;
    }
};