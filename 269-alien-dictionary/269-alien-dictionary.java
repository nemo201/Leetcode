class Solution {
    public String alienOrder(String[] words) {
        //find all unique letters
        
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        
        //find all edges;
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            //check word2 is not a prefix of word1
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            
            //find first non match and insert into corresponding relation
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        
        //bfs
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0))
                q.offer(c);
        }
        
        while (!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);
            
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                
                if (counts.get(next).equals(0))
                    q.offer(next);
            }
        }
        if (sb.length() < counts.size())
            return "";
        
        return sb.toString();
    }
}