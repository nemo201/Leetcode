class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxsofar = 0, maxcur = 0;
        for (int i = 1; i < prices.size(); i++) {
            maxcur = max(0, maxcur += prices[i] - prices[i - 1]);
            maxsofar = max(maxsofar, maxcur);
        }
        return maxsofar;
    }
};