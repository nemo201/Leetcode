class WordDictionary {
    
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEnd;
    }
    
    private TrieNode root = new TrieNode();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (node.children[cur - 'a'] == null) {
                node.children[cur - 'a'] = new TrieNode();
            }
            node = node.children[cur - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }
    
    public boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length)
            return node.isEnd;
        
        if (chs[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(chs, k + 1, node.children[i]))
                    return true;
            }
        } else {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */