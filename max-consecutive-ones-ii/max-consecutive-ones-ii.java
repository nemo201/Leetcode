class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longest = 0;
        int left = 0, right = 0;
        int zeros = 0;
        
        while (right < nums.length) {
            if (nums[right] == 0)
                zeros++;
            
            while (zeros == 2) {
                if (nums[left] == 0)
                    zeros--;
                
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}