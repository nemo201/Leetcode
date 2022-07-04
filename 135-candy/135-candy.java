class Solution {
    public int candy(int[] r) {
        int[] candies = new int[r.length];
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < r.length; i++) {
            if (r[i] > r[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
        
        int sum = candies[r.length - 1];
        
        for (int i = r.length - 2; i >= 0; i--) {
            if (r[i] > r[i + 1])
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            
            sum += candies[i];
        }
        return sum;
    }
}