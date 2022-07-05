class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums)
            set.add(num);
        
        int max = 0;
        
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int streak = 1;
                
                while (set.contains(curNum + 1)) {
                    curNum++;
                    streak++;
                }
                max = Math.max(max, streak);
            }
        }
        return max;
    }
}