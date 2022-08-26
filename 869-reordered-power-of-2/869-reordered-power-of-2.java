class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] A = count(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(A, count(1 << i)))
                return true;
        }
        return false;
    }
    
    private int[] count(int n) {
        int[] ans = new int[10];
        while (n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}