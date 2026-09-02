class WordFilter {
    class TrieNode {
        TrieNode[] children = new TrieNode[27];
        int index = -1;
    }

    TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];

            for (int start = 0; start <= word.length(); start++) {
                String combined = word.substring(start) + "#" + word;

                insert(combined, index);
            }
        }
    }

    private void insert(String s, int index) {
        TrieNode node = root;

        for (char c  :s.toCharArray()) {
            int pos = (c == '#') ? 26 : c - 'a';

            if (node.children[pos] == null) {
                node.children[pos] = new TrieNode();
            }

            node = node.children[pos];
            node.index = index;
        }
    }
    
    public int f(String pref, String suff) {
        String search = suff + "#" + pref;

        TrieNode node = root;

        for (char c : search.toCharArray()) {
            int pos = (c == '#') ? 26 : c - 'a';

            if (node.children[pos] == null) {
                return -1;
            }
            node = node.children[pos];
        }
        return node.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */