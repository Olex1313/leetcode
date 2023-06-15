package model;


import java.util.*;

public class TrieNode {
    private Map<Character, TrieNode> children;
    private boolean isEndOfWord;

    public TrieNode(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
        this.children = new TreeMap<>();
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void addNode(Character charForNode, TrieNode node) {
        this.children.put(charForNode, node);
    }

    public boolean hasNode(Character character) {
        return this.children.containsKey(character);
    }

    public TrieNode getNode(Character character) {
        return this.children.get(character);
    }

    public List<TrieNode> getChildren() {
        return children.values().stream().toList();
    }

}
