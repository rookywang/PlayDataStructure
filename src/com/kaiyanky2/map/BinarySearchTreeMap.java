package com.kaiyanky2.map;

import com.kaiyanky2.binarytree.BinarySearchTree;

public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    public BinarySearchTreeMap() {
        root = null;
        size = 0;
    }

    /**
     * 在以 node 为根的树种根据 key 找到对应 Node
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNodeByKey(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.equals(node.key)) {
            return node;

        } else if (key.compareTo(node.key) > 0) {
            return getNodeByKey(node.right, key);

        } else {
            return getNodeByKey(node.left, key);
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 以 node 为根的二叉树添加元素<key, value>
     *
     * @param node
     * @param key
     * @param value
     * @return 添加后的二叉搜索树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);

        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);

        } else {
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Node delNode = getNodeByKey(root, key);
        if (delNode != null) {
            root = remove(root, key);
            return delNode.value;
        }

        return null;
    }

    /**
     * 在以 node 为根的二叉搜索树中删除键为 key 的 Node
     *
     * 重点啊，非常重点
     *
     * @param node
     * @param key
     * @return 移除操作后的二叉树的根
     */
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;

        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;

        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点
            Node newNode = minimum(node.right);
            newNode.right = removeMin(node.right);
            newNode.left = node.left;
            node.left = node.right = null;
            return newNode;
        }
    }

    /**
     * 找到以 node 为根的二叉搜索树的最小值所在 Node
     *
     * @param node
     * @return 最小值所在 Node
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return null;
        }
        return minimum(node.left);
    }

    /**
     * 删除以 node 为根的搜索二叉树最小值所在 Node
     *
     * @param node
     * @return 操作后的二叉搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNodeByKey(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node cur = getNodeByKey(root, key);
        return cur == null ? null : cur.value;
    }

    @Override
    public void set(K key, V value) {
        Node cur = getNodeByKey(root, key);
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


    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
