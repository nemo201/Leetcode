class Solution {
public:
    int countOrders(int n) {
        long ans = 1;
        int MOD = 1e9 + 7;
        
        for (int i = 1; i <= 2 * n; ++i) {
            ans = ans * i;
            
            // We only need to divide the result by 2 n-times.
            // To prevent decimal results we divide after multiplying an even number.
            if (i % 2 == 0) {
                ans = ans / 2;
            }
            ans %= MOD;
        }
        return ans;
    }
    };