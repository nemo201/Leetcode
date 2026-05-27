class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //create a set
        Set<String> dict = new HashSet<>(wordList);
        //check if end word is in set
        if (!dict.contains(endWord)) {
            return 0;
        }

        //create a q and add the begining word
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        //create a level(counter) to keep track of number of changes
        int level = 1;
        //while q is not empty
        while (!q.isEmpty()) {
            int size = q.size();
            //check if the q has the endword if yes then return level
            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (cur.equals(endWord)) {
                    return level;
                }
                //convert the word into character array and check by replacing ever character if new word is in set
                char[] word = cur.toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char og = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;
        //if in set then add new word to q and remove from set
                        String next = new String(word);
                        if (dict.contains(next)) {
                            q.offer(next);
                            dict.remove(next);
                        }
                    }
        //backtrack to original word
                    word[j] = og;
                }
            }
            level++;
        }
        return 0;        
    }
}