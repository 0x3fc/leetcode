package StreamOfCharacters;

import java.util.ArrayList;
import java.util.List;

class StreamChecker {

    class ReversedTrie {
        private int size = 0;

        class TrieNode {
            public TrieNode[] children;
            public boolean isEnd = false;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }

        public TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode current = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.isEnd = true;
            size = Math.max(size, word.length());
        }

        public boolean hasAnyPrefix(List<Character> list) {
            TrieNode current = root;
            int maxIters = Math.max(list.size() - size - 1, 0);

            for (int i = list.size() - 1; i >= maxIters && current != null; i--) {
                char c = list.get(i);
                current = current.children[c - 'a'];
                if (current != null && current.isEnd) {
                    return true;
                }
            }
            return false;
        }
    }

    private ReversedTrie trie = new ReversedTrie();
    private List<Character> list = new ArrayList<>();

    public StreamChecker(String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
    }

    public boolean query(char letter) {
        list.add(letter);
        return trie.hasAnyPrefix(list);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words); boolean param_1 =
 * obj.query(letter);
 */
