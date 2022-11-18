class Solution {
    public boolean isUgly(int n) {
        if (n <= 0)
            return false;
        
        for (int  factor : new int[]{2, 3, 5})
            n = check(n, factor);
        
        return n == 1;
    }
    
    private int check(int divi, int div) {
        while (divi % div == 0)
            divi /= div;
        
        return divi;
    }
}