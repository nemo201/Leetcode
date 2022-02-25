class Solution {
public:
    int compareVersion(string v1, string v2) {
        for (auto& v : v1)
            if (v == '.')
                v = ' ';
        for (auto& v : v2)
            if (v == '.')
                v = ' ';
        
        istringstream s1(v1), s2(v2);
        
        while (1) {
            int n, m;
            if (!(s1 >> n))
                n = 0;
            if (!(s2 >> m))
                m = 0;
            if (!s1 && !s2)
                return 0;
            if (n > m)
                return 1;
            if (m > n)
                return -1;
        }
    }
};