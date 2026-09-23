class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return level;
                }

                char[] word = cur.toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char og = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;
                        String next = new String(word);
                        if (dict.contains(next)) {
                            q.offer(next);
                            dict.remove(next);
                        }
                    }
                    word[j] = og;
                }
            }
            level++;
        }
        return 0;
    }
}