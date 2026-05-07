class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder str = new StringBuilder();
            for (int count : freq) {
                str.append(count).append("#");
            }

            String key = str.toString();

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> value : map.values()) {
            ans.add(value);
        }

        return ans;
    }
}