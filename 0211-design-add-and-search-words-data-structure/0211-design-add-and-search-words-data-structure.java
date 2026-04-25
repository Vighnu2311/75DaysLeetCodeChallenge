class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Add word to Trie
    public void addWord(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }

    // Search word with '.' support
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int i, TrieNode node) {
        if (node == null) return false;

        if (i == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(i);

        if (ch == '.') {
            // Try all possible children
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, i + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            return searchHelper(word, i + 1, node.children[ch - 'a']);
        }
    }
}