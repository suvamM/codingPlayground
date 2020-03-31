package codingPlayground.trie;

import java.util.*;

public class Trie {

    private class TrieNode
    {
        // character this node holds
        private char c;

        // is this node the end of a word?
        private boolean isTerminated;

        private HashMap<Character, TrieNode> children;

        public TrieNode () {
            isTerminated = false;
            children = new HashMap<Character, TrieNode>();
        }

        public TrieNode (char c) {
            this.c = c;
            isTerminated = false;
            children = new HashMap<Character, TrieNode>();
        }

        public void addWord (String word) {
            if (word.length() == 0 || word == null) {
                return;
            }

            char firstChar = word.charAt(0);

            // do we already have a child for this character?
            if (!children.containsKey(firstChar)) {
                TrieNode child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }

            // does the word have more characters? if so, recurse, else set terminate
            if (word.length() > 1 ) {
                children.get(firstChar).addWord(word.substring(1));
            }
            else {
                children.get(firstChar).setTerminated();
            }
        }

        public boolean contains (String word) {

            if (word == null || word.length() == 0) {
                return false;
            }

            char firstChar = word.charAt(0);

            // check if there is a valid child for this character
            if (!children.containsKey(firstChar)) {
                return false;
            }

            // if word has length 1, check if we terminate, otherwise recurse
            if (word.length() == 1) {
                return children.get(firstChar).isTerminated();
            }
            else {
                return children.get(firstChar).contains(word.substring(1));
            }
        }

        public boolean isTerminated() {
            return isTerminated;
        }

        public void setTerminated() {
            isTerminated = true;
        }

        public void resetTerminated() {
            isTerminated = false;
        }
    }

    TrieNode root;

    // create a trie with a set of words
    public Trie(List<String> words)
    {
        root = new TrieNode();

        for (String word : words
             ) {
            root.addWord(word);
        }
    }

    public Trie () {
        root = new TrieNode();
    }

    /*
    add a word to the trie.
     */
    public boolean addWord(String word)
    {
        try {
            root.addWord(word);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void addWords (List<String> words) {
        for (String word: words
             ) {
            root.addWord(word);
        }
    }

    /*
    check if a word is present in the trie.
     */
    public boolean contains(String word)
    {
        return root.contains(word);
    }
}
