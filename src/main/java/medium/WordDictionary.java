package medium;

import model.TrieNode;


/**
 * class to store words
 */
public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode(true);
    }

    /**
     * @param word any word to persist
     */
    public void addWord(String word) {
        TrieNode cur = root;
        for (Character c : word.toCharArray()) {
            if (cur.hasNode(c)) {
                cur = cur.getNode(c);
            } else {
                TrieNode newNode = new TrieNode(false);
                cur.addNode(c, newNode);
                cur = newNode;
            }
        }
        cur.setEndOfWord(true);
    }

    /**
     * @param word word to lookup, matches '.' as any symbol
     * @return true if word is present, otherwise false
     */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int charIdx, TrieNode curNode) {
        if (charIdx == word.length()) return curNode.isEndOfWord();
        char c = word.charAt(charIdx);
        if ('.' == c) {
            for (var node : curNode.getChildren()) {
                if (searchHelper(word, charIdx + 1, node)) {
                    return true;
                }
            }
        }
        if (!curNode.hasNode(c)) return false;
        return searchHelper(word, charIdx + 1, curNode.getNode(c));
    }

}
