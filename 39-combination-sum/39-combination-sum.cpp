class Solution {
private:
    void findcomb(int first, vector<int> &arr, int target, vector<vector<int>> &ans, vector<int> &ds) {
        if (first == arr.size()) {
            if (target == 0)
                ans.push_back(ds);
            return;
        }
        
        if (arr[first] <= target) {
            ds.push_back(arr[first]);
            findcomb(first, arr, target - arr[first], ans, ds);
            ds.pop_back();
        }
        findcomb(first + 1, arr, target, ans, ds);
    }
    
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> ds;
        findcomb(0, candidates, target, ans, ds);
        return ans;
    }
};