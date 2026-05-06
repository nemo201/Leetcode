class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            int[] freq = new int[26];
            for (char c : strs[i].toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int count : freq) {
                sb.append(count).append("#");
            }

            String key = sb.toString();

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>(Arrays.asList(strs[i]));
                map.put(key, list);
            }
        }

        for (List list : map.values()) {
            ans.add(list);
        }

        return ans;
    }
}