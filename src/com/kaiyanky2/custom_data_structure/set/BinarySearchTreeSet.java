package com.kaiyanky2.custom_data_structure.set;

import com.kaiyanky2.custom_data_structure.binarytree.BinarySearchTree;

public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {


    private BinarySearchTree<E> binarySearchTree;

    public BinarySearchTreeSet() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        binarySearchTree.add(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }

    @Override
    public int getSize() {
        return binarySearchTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }
}
