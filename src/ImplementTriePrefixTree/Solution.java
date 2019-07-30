package ImplementTriePrefixTree;

class Trie {
    TrieNode root = new TrieNode();

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] next = new TrieNode[26];
    }

    public void insert(String word) {
        traverse(word, true).isEnd = true;
    }

    public boolean search(String word) {
        TrieNode end = traverse(word, false);

        return end != null && end.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode end = traverse(prefix, false);

        return end != null;
    }

    private TrieNode traverse(String word, boolean isCreateMode) {
        TrieNode iter = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (iter.next[index] == null) {
                if (!isCreateMode) {
                    return null;
                }

                iter.next[index] = new TrieNode();
            }

            iter = iter.next[index];
        }

        return iter;
    }
}
