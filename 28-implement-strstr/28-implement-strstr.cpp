class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = needle.size();
        if (n == 0)
            return 0;
        if (haystack.size() < n)
            return -1;
        
        for (int i = 0; i <= haystack.size() - n; i++) {
            if (haystack[i] == needle[0] && haystack[i + n - 1] == needle[n - 1]) {
                for (int j = 0; j < n && haystack[i + j] == needle[j]; j++)
                    if (j == n - 1)
                        return i;
            }
        }
        return -1;
    }
};