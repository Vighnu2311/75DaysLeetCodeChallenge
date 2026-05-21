class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
            }

            node.word = word;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        // Boundary check
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        // Visited or not in trie
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        // Word found
        if (node.word != null) {
            result.add(node.word);
            node.word = null; // avoid duplicates
        }

        // Mark visited
        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);

        // Restore character
        board[r][c] = ch;
    }
}