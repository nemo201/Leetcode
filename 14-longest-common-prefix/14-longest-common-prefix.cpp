class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0)
            return "";
        return longest (strs, 0, strs.size() - 1);
    }
    
    string longest(vector<string> &strs, int l, int r) {
        if (l == r)
            return strs[l];
        else {
            int mid = (l + r) / 2;
            string lcpleft = longest(strs, l, mid);
            string lcpright = longest(strs, mid + 1, r);
            return common(lcpleft, lcpright);
        }
    }
    
    string common(string left, string right) {
        int mi = min(left.size(), right.size());
        for (int i = 0; i < mi; i++) {
            if (left[i] != right[i])
                return left.substr(0, i);
        }
        return left.substr(0, mi);
    }
};