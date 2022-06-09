package trie;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TrieNode implements Serializable {

    Character ch;
    Map<Character, TrieNode> children;
    boolean isTerminal;

    int frequency;

    /**
     * Parametrised constructor
     *
     * @param ch character for the TrieNode
     */
    public TrieNode(Character ch) {
        this.ch = ch;
        children = new HashMap<>();
        isTerminal = false;
        // default frequency when TrieNode is being created
        frequency = 1;
    }

    /**
     * Add word into Trie
     *
     * @param word word to be added into Trie
     */
    public void addWord(String word) {
        // this will point to root here
        TrieNode current = this;
        for (int index = 0; index < word.length(); index++) {
            Character ch = word.charAt(index);
            if (!current.children.containsKey(ch)) {
                // add character into Trie in not already present
                current.children.put(ch, new TrieNode(ch));
            } else {
                // increase frequency
                current.children.get(ch).frequency += 1;
            }
            // move to child node
            current = current.children.get(ch);
        }
        // flag to identify the end of the current word
        current.isTerminal = true;
    }

    /**
     * Search word into Trie
     *
     * @param word
     * @return true if word is found, otherwise return false
     */
    public boolean searchWord(String word) {
        // this will point to root here
        TrieNode current = this;
        for (int index = 0; index < word.length(); index++) {
            Character ch = word.charAt(index);
            if (!current.children.containsKey(ch)) {
                // if current character is not present
                return false;
            }
            current = current.children.get(ch);
        }
        // if this is not the end of the word
        if (current.isTerminal == false)
            return false;
        return true;
    }

    /**
     * Remove word from the Trie
     *
     * @param word word to be removed
     * @return true if word is removed, otherwise return false
     */
    public boolean removeWord(String word) {
        if (searchWord(word)) {
            // remove only when word is present
            // this will point to root here
            TrieNode current = this;
            for (int index = 0; index < word.length(); index++) {
                Character ch = word.charAt(index);
                if (current.children.get(ch).frequency == 1) {
                    // delete node and no need to delete further child nodes as frequency will
                    // always be 1 for child nodes
                    current.children.remove(ch);
                    return true;
                } else {
                    // decrease the frequency
                    current.children.get(ch).frequency -= 1;
                    current = current.children.get(ch);
                }
            }
            // if word is present as substring of another word, mark flag as false
            current.isTerminal = false;
            return true;
        }
        return false;
    }
}