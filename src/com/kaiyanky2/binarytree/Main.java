package com.kaiyanky2.binarytree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        int[] numArray = {35, 23, 6, 58, 14};
        for(int num: numArray) {
            binarySearchTree.add(num);
        }

//        binarySearchTree.preOrder();
        binarySearchTree.inOrder();

        System.out.println();

//        binarySearchTree.preOrderNR();

//        binarySearchTree.levelOrder();

//        System.out.println(binarySearchTree);
    }
}
