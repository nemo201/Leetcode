class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] freq = new int[26];

            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int c : freq) {
                sb.append(c).append("#");
            }

            String key = sb.toString();

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}