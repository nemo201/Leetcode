class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int ptr = i;
            Set<Character> set = new HashSet<>();
            while (ptr < s.length() && !set.contains(s.charAt(ptr))) {
                set.add(s.charAt(ptr++));
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}