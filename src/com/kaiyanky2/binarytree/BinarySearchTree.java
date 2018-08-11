package com.kaiyanky2.binarytree;

/**
 * 二叉搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(null, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node(e, null, null);
            size++;
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);

        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);

        } else {
            // 相等的情况
        }

        return node;
    }

    private class Node {

        public E e;
        public Node left, right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

}
