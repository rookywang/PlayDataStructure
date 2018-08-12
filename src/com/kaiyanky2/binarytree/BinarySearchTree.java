package com.kaiyanky2.binarytree;

import com.kaiyanky2.queue.LinkedListQueue;
import com.kaiyanky2.stack.LinkedListStack;

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

    /**
     * 添加操作
     *
     * @param e 被添加节点元素
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 以 node 为根节点的二叉搜索树添加元素 e
     *
     * @param node
     * @param e
     * @return 根节点 node
     */
    private Node add(Node node, E e) {
        if (node == null) {
            node = new Node(e, null, null);
            size++;
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);

        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);

        } else {
            // 相等的情况
        }

        return node;
    }

    /**
     * 是否包含元素 e
     *
     * @param e
     * @return true: 包含
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 以 node 为根节点的二叉搜索树是否包含元素 e
     *
     * @param node
     * @param e
     * @return true: 包含
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.equals(e)) {
            return true;
        } else if (node.e.compareTo(e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 以 node 为根节点的二叉搜索树的前序遍历
     *
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     * 二叉搜索树的中序遍历就是二叉搜索树排好序的顺序
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 以 node 为根的搜索二叉树的中序遍历
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 以 node 为根的搜索二叉树的后序遍历
     *
     * @param node
     */
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    /**
     * 前序遍历非递归实现
     */
    public void preOrderNR() {
        preOrderNR(root);
    }

    /**
     * 以 node 为根节点的二叉搜索树的前序遍历非递归实现
     *
     * @param node
     */
    private void preOrderNR(Node node) {
        if (node == null) {
            return;
        }

        LinkedListStack<Node> stack = new LinkedListStack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二叉搜索树的层序遍历
     */
    public void levelOrder() {
        levelOrder(root);
    }

    /**
     * 以 node 为根节点的二叉搜索树的层序遍历（广度优先遍历）
     *
     * @param node
     */
    private void levelOrder(Node node) {
        if (node == null) {
            return;
        }

        LinkedListQueue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateString(root, 0, sb);

        return sb.toString();
    }

    private void generateString(Node node, int depth, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(generateDepthString(depth) + "null\n");
            return;
        }

        stringBuilder.append(generateDepthString(depth) + node.e + "\n");

        generateString(node.left, depth + 1, stringBuilder);
        generateString(node.right, depth + 1, stringBuilder);
    }

    private String generateDepthString(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }

        return stringBuilder.toString();
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
