package com.kaiyanky2.map;

public class LinkedListMap<K, V> implements Map<K, V> {


    private Node dummyHead;
    private int size;


    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 根据 key 找到对应 Node
     *
     * @param key
     * @return
     */
    private Node getNodeByKey(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur;
            }

            cur = cur.next;
        }

        return null;
    }

    @Override
    public void add(K key, V value) {
        Node cur = getNodeByKey(key);
        if (cur == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++; // 不要忘记维护

        } else {
            cur.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (key.equals(pre.next.key)) {
                break;
            }

            pre = pre.next;
        }

        if (pre.next != null) {
            Node del = pre.next;
            pre.next = del.next;
            del.next = null;
            size--;
            return del.value;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNodeByKey(key) != null;
    }

    @Override
    public V get(K key) {
        Node cur = getNodeByKey(key);
        return cur == null? null: cur.value;
    }

    @Override
    public void set(K key, V value) {
        Node cur = getNodeByKey(key);
        if (cur == null) {
            throw new IllegalArgumentException("No such key.");
        }

        cur.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node{

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }

}
