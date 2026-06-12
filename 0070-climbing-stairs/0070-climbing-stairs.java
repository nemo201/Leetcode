class Solution {
    public int climbStairs(int n) {
        if (n < 3) 
            return n;
        
        int one = 1;
        int two = 2;
        int next = 0;

        for (int i = 3; i <= n; i++) {
            next = one + two;
            one = two;
            two = next;
        }

        return next;
    }
}