class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 0; 
       
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}