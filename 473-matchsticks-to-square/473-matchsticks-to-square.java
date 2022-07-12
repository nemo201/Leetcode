class Solution {
    List<Integer> nums = new ArrayList<>();
    int[] sums = new int[4];
    int possibleSquareSide;
    
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length == 0)
            return false;
        
        int L = matchsticks.length;
        int perimeter = 0;
        for (int i = 0; i < L; i++) {
            perimeter += matchsticks[i];
        }
        
        this.possibleSquareSide = perimeter / 4;
        if (this.possibleSquareSide * 4 != perimeter)
            return false;
        
        for (int n : matchsticks)
            this.nums.add(n);
            
        Collections.sort(this.nums, Collections.reverseOrder());
        return dfs(0);
    }
    
    private boolean dfs(int index) {
        if (index == this.nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }
        
        int element = this.nums.get(index);
        
        for (int i = 0; i < 4; i++) {
            if (this.sums[i] + element <= this.possibleSquareSide) {
                this.sums[i] += element;
                if (dfs(index + 1))
                    return true;
                this.sums[i] -= element;
            }
        }
        return false;
    }
}