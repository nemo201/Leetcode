class Solution {
    public int candy(int[] r) {
        int[] lr = new int[r.length];
        int[] rl = new int[r.length];
        
        Arrays.fill(lr, 1);
        Arrays.fill(rl, 1);
        
        for (int i = 1; i < r.length; i++) {
            if (r[i] >r[i - 1])
                lr[i] = lr[i - 1] + 1;
        }
        
        for (int i = r.length - 2; i >= 0; i--) {
            if (r[i] > r[i + 1]) {
                rl[i] = rl[i + 1] + 1;
            }
        }
        
        int sum = 0;
        
        for(int i = 0; i < r.length; i++) {
            sum += Math.max(lr[i], rl[i]);
        }
        return sum;
    }
}