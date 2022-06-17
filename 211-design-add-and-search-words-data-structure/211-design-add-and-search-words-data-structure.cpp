class TrieNode {
public:
    TrieNode *next[26]{};
    bool is_leaf = false;
    TrieNode *get(char c) { return next[c - 'a']; }
    void add(char c) { next[c - 'a'] = new TrieNode; }
};

class WordDictionary {
public:
    WordDictionary() : root(new TrieNode) {}
    void addWord(const string &word) {
        auto p = root;
        for (auto c : word) {
            if (!p->get(c)) p->add(c);
            p = p->get(c);
        }
        p->is_leaf = true;
    }
    bool search(const string &word) {  return search(word, 0, root); }
private:
    bool search(const string &word, int pos, TrieNode *root) {
        if (pos == word.size()) return root->is_leaf;
        if (word[pos] != '.') {
            root = root->get(word[pos]);
            return root ? search(word, pos + 1, root) : false;
        }
        for (auto i = 0; i < 26; ++i)
            if (root->next[i] && search(word, pos + 1, root->next[i]))
                return true;
        return false;
    }
    TrieNode *root;
};