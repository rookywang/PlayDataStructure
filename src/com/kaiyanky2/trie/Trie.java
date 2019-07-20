package com.kaiyanky2.trie;

import java.util.Objects;
import java.util.TreeMap;

public class Trie {

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 将单词 word 添加到 Trie 中
     *
     * @param word 单词
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Objects.isNull(cur.next.get(c))) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 判断单词是否已经存在于 trie，如果不存在，进行标记
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询 Trie 中是否存在单词 word
     *
     * @param word 要查询的单词
     * @return true：存在
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Objects.isNull(cur.next.get(c))) {
                return false;
            }
            cur = cur.next.get(c);
        }
        // 判断 cur 这个节点是不是单词末尾
        return cur.isWord;
    }

    /**
     * 查询 Trie 中是否存在以 prefix 为前缀的单词
     * 某个单词也是单词的前缀，比如 dog 是 dog 的前缀
     *
     * @param prefix 单词前缀
     * @return true：存在
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (Objects.isNull(cur.next.get(c))) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * 获取 Trie 中存储的单词的数量
     *
     * @return 单词的数量
     */
    public int getSize() {
        return size;
    }

    /**
     * Trie 的节点
     */
    private class Node {

        /**
         * 是否是单词结尾，true：是
         */
        public boolean isWord;

        /**
         * 当前节点与子节点的映射集合
         */
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }
}
