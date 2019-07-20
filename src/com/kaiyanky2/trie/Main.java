package com.kaiyanky2.trie;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("one");
        trie.add("on");
        trie.add("kid");
        trie.add("contains");
        trie.add("add");
        System.out.println(trie.contains("o"));
        System.out.println(trie.contains("on"));
        System.out.println(trie.contains("one"));
        System.out.println(trie.isPrefix("o"));
        System.out.println(trie.isPrefix("on"));
        System.out.println(trie.isPrefix("one"));
    }
}
