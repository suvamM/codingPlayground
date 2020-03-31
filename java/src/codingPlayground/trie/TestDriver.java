package codingPlayground.trie;

import java.util.*;

/*
 A class to demo usage of Trie.
 */
public class TestDriver {

    public static void main(String[] args)
    {
        List<String> words = new ArrayList<String>();

        Trie trie = new Trie();
        System.out.println("Does trie contain popl before adding anything?: " + trie.contains("popl"));
        words.add("chotto");
        words.add("popl");
        words.add("cat");
        words.add("muenchkin");
        words.add("poop");
        trie.addWords(words);

        System.out.println("Does trie contain popl?: " + trie.contains("popl"));
        System.out.println("Does trie contain laha?: " + trie.contains("laha"));
        System.out.println("Does trie contain null?: " + trie.contains(null));
        System.out.println("Does trie contain poop?: " + trie.contains("poop"));
    }
}
