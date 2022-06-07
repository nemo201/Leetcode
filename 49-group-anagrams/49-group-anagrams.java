class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        
        if (strs.length == 0)
            return ans;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char []freq = new char[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String str = new String(freq);
            if (map.get(str) == null) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        
        ans.addAll(map.values());
        return ans;
    }
}